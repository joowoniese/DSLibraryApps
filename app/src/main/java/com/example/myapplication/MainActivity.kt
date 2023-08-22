package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // lateinit var binding: ActivityMainBinding
    class MyFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments = listOf(Fragment1(), Fragment2() , Fragment3(), Fragment4(), Fragment5())
        }
        override fun getItemCount(): Int {
            return fragments.size
        }
        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 스플래시 화면
        // setTheme(R.style.Theme_MyApplication)

        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewpager.adapter = MyFragmentAdapter(this) // 어댑터 연결

        val tabIconArray = arrayOf<Int>(R.drawable.tab1, R.drawable.tab2, R.drawable.tab3, R.drawable.tab4, R.drawable.tab5)

        // 탭 레이아웃과 뷰 페이저 연동
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.setIcon(tabIconArray[position])
        }.attach()

        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // val transaction = fragmentManager?.beginTransaction()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.commit() // 커밋
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // TODO("Not yet implemented")
            }
        })
    }
}