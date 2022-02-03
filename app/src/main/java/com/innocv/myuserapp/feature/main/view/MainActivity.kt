package com.innocv.myuserapp.feature.main.view

import com.innocv.myuserapp.UserApplication
import com.innocv.myuserapp.common.base.activity.BaseActivityFragmentScreen
import com.innocv.myuserapp.databinding.ActivityMainBinding
import com.innocv.myuserapp.feature.main.viewmodel.MainViewModelInterface
import javax.inject.Inject

class MainActivity : BaseActivityFragmentScreen() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModelInterface

    override fun next() {
    }

    override fun previous() {
    }

    override fun inject() {
        (this.application as UserApplication).getApplicationComponent().getMainComponent()
            .inject(this)
    }

    override fun afterInject() {
        this.binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
    }

    override fun configureUI() {
    }

    override fun render() {
    }

    override fun setListeners() {
        this.binding.floatActionButton.setOnClickListener {
            this.viewModel.navigateToNewUser(this)
        }
    }
}