package com.rokid.mobile.sdk.demo.skill

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.rokid.mobile.lib.base.util.Logger
import com.rokid.mobile.lib.entity.event.skill.EventAlarmBean
import com.rokid.mobile.lib.entity.event.skill.EventRemindBean
import com.rokid.mobile.sdk.RokidMobileSDK
import com.rokid.mobile.sdk.demo.R
import com.rokid.mobile.sdk.demo.base.BaseFragment
import kotlinx.android.synthetic.main.skill_fragment_alarm.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Description: TODO
 * Author: Shper
 * Version: V0.1 2018/2/12
 */
class SkillAlarmFragment : BaseFragment() {

    private lateinit var eventTxt: TextView
    private lateinit var deviceIdEdit: EditText

    override fun layoutId(): Int = R.layout.skill_fragment_alarm

    override fun initViews() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }

        eventTxt = rootView!!.skill_txt
        deviceIdEdit = rootView!!.skill_device_sn
    }

    override fun initListeners() {
        rootView!!.skill_alarm_list.setOnClickListener here@ {
            val deviceId = deviceIdEdit.text.toString()
            if (deviceId.isEmpty()) {
                toast("请正确输入 SN")
                return@here
            }

            RokidMobileSDK.skill.alarm().getList(deviceIdEdit.text.toString())
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onAlarmEvent(eventAlarm: EventAlarmBean) {
        Logger.d("onSysInfo eventDeviceSysUpdate" + Gson().toJson(eventAlarm))
        eventTxt.append("\n" + Gson().toJson(eventAlarm))
    }

}