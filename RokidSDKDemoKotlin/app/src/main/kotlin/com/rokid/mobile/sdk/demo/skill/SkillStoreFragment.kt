package com.rokid.mobile.sdk.demo.skill

import com.rokid.mobile.sdk.demo.R
import com.rokid.mobile.sdk.demo.base.BaseFragment
import kotlinx.android.synthetic.main.skill_fragment_store.*

/**
 * Description: TODO
 * Author: Shper
 * Version: V0.1 2018/2/26
 */
class SkillStoreFragment : BaseFragment() {

    override fun layoutId(): Int {
        return R.layout.skill_fragment_store
    }

    override fun initViews() {
    }

    override fun initListeners() {
    }

    override fun onResume() {
        super.onResume()
        skill_store_webview.loadUrl("https://skill.rokid.com/storev2")
    }

}