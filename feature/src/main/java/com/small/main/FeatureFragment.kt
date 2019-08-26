package com.small.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.trust.library.arouter.RouterPath
import kotlinx.android.synthetic.main.fragment_feature.*

/**
 * Create by wangqingqing
 * On 2019/8/23 16:25
 * Copyright(c) 2018 极光
 * Description
 */
@Route(path = RouterPath.FRAGMENT_FEATURE)
class FeatureFragment : Fragment() {


    val arrayOfFragments = arrayOf(Demo1Fragment(), Demo2Fragment())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feature, null)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager.apply {
            adapter = object :
                FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getItem(position: Int): Fragment {
                    return arrayOfFragments[position]
                }

                override fun getCount(): Int {
                    return arrayOfFragments.size
                }
            }
        }
    }

}