package com.innocv.myuserapp.feature.main.view

import com.innocv.myuserapp.UserApplication
import com.innocv.myuserapp.common.base.activity.BaseActivityFragmentScreen
import com.innocv.myuserapp.databinding.ActivityMainBinding
import com.innocv.myuserapp.feature.listuser.view.ListUserFragment
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

        //Add first fragment
        this.currentFragment = ListUserFragment()
        supportFragmentManager.beginTransaction()
                .replace(binding.userFragment.id,
                        this.currentFragment,
                        this.currentFragment::class.java.simpleName)
                .commitAllowingStateLoss()
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