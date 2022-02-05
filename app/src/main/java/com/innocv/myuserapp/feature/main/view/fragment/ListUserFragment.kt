package com.innocv.myuserapp.feature.main.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import com.innocv.myuserapp.R
import com.innocv.myuserapp.UserApplication
import com.innocv.myuserapp.common.base.fragment.BaseFragment
import com.innocv.myuserapp.databinding.FragmentUserListBinding
import com.innocv.myuserapp.feature.main.viewmodel.fragment.ListUserViewModelInterface
import javax.inject.Inject

class ListUserFragment: BaseFragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var observer: LiveData<ListUserViewModelInterface>

    @Inject
    lateinit var viewModel: ListUserViewModelInterface

    override fun configureUI() {
        this.viewModel.getUserList()
    }

    override fun render() {
    }

    override fun setListeners() {
    }

    override fun inject() {
        (this.activity?.application as UserApplication).getApplicationComponent().getMainComponent()
                .inject(this)
    }

    override fun getLayoutContext(): Context {
        return this.requireContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.binding = FragmentUserListBinding.bind(
            inflater.inflate(
                R.layout.fragment_user_list,
                container,
                false
            )
        )
        return this.binding.root
    }
}