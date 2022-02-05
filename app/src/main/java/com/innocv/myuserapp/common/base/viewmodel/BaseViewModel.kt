package com.innocv.myuserapp.common.base.viewmodel

import com.innocv.myuserapp.common.base.viewmodel.livedata.BaseLiveData
import com.innocv.myuserapp.common.base.viewmodel.viewstate.BaseViewState
import com.innocv.myuserapp.data.network.model.base.BaseDataOut
import com.innocv.myuserapp.domain.bm.base.BaseBMInterface
import com.innocv.myuserapp.domain.usecase.base.BaseUseCase
import com.innocv.myuserapp.domain.usecase.base.UseCaseResponse
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Future

abstract class BaseViewModel: BaseViewModelInterface {

    private val disposables: CompositeDisposable = CompositeDisposable()

    private var viewModelObserver = BaseLiveData<BaseViewState>()
    private var componentObserver = BaseLiveData<BaseViewState>()

    fun <Type, P: BaseDataOut> executeUseCase(useCase: BaseUseCase<Type, P>) = try {
        //Cast useCase in order to be able to execute it
        useCase as BaseUseCase<Type, P>
        //Create future variable to be observed, if null, throw exception
        val future = useCase.execute() ?: throw Exception()
        //Create observer on our future variable
        execute(future,
            {
                try {
                    //Check if returned BM is an instance of NowPayBaseErrorBMInterface
                    val state: BaseViewState? = if (it.success){
                        //If else, then the call has been successful and execute doOnSuccessMethod on the child
                        val bm = future.get().bm ?: throw Exception()
                        this.doOnSuccess(bm)
                    } else {
                        throw Exception()
                    }
                    //If state has been initialized then throw state
                    if (state != null) {
                        //Throw state
                        updateView(state)
                    } else {
                        throw Exception()
                    }
                } catch (exception: Exception) {
                    throw exception
                }
            }, {
                throw Exception()
            }
        )
    } catch (exception: Exception) {
        throw exception
    }

    open fun doOnSuccess(bmInterface: BaseBMInterface): BaseViewState? {
        return null
    }

    protected fun updateView(viewState: BaseViewState?){
        //HealthCheck
        if (viewState == null) return
        this.viewModelObserver.getMutableObserver().postValue(viewState)
    }

    protected fun updateComponentView(viewState: BaseViewState){
        this.componentObserver.getMutableObserver().postValue(viewState)
    }

    override fun getViewModelObserver(): BaseLiveData<BaseViewState> = this.viewModelObserver
    override fun getComponentObserver(): BaseLiveData<BaseViewState> = this.componentObserver

    private fun execute(
            source: Future<UseCaseResponse>,
            onSuccess: Consumer<UseCaseResponse>,
            onError: Consumer<UseCaseResponse>
    ) {
        addDisposable(
            Observable.fromFuture(source)
                .subscribeOn(Schedulers.io())
                .subscribe(onSuccess, { onError })
        )
    }

    /**
     * Adds a disposable.
     *
     * @param disposable new disposable
     **/
    protected open fun addDisposable(disposable: Disposable) {
        this.disposables.add(disposable)
    }

}