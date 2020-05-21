package com.wd.doctor.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wd.doctor.fragment.AskWithin
import com.wd.doctor.fragment.wy.*

/**
 * @author 王阳
 * Class :1708A
 * @description:
 * @date :2020/5/21 7:56
 * @classname :FragmentPagerAsk
 */
class FragmentPagerAsk(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    //
    val stringList= listOf<String>("内科","眼科","骨科","小儿科","传染病科","皮肤科","耳鼻喉科","精神病科")
    override fun getItem(position: Int): Fragment {
        if(position==0){
            return AskWithin()
        }else if(position==1){
            return AskEye()
        }else if(position==2){
            return AskBone()
        }else if(position==3){
            return AskChildren()
        }else if(position==4){
            return AskInfectiousDiseases()
        }else if(position==5){
            return AskSkin()
        }else if(position==6){
            return AskOtolaryngology()
        }else{
            return AskMentalDisease()
        }
    }

    override fun getCount(): Int {
        return stringList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return stringList.get(position)
    }
}