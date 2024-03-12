package com.example.tablayout_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.tablayout_viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        binding.apply {

            viewPager2.adapter = ViewPagerAdapter(fragmentList,this@MainActivity.supportFragmentManager,lifecycle) //adapter is done

            TabLayoutMediator(tabLayout,viewPager2){ tab , position ->

                when(position){

                    0 -> { tab.text = "Home"
                            tab.icon = ContextCompat.getDrawable(this@MainActivity,R.drawable.home) }
                    1 -> { tab.text = "Dinner"
                        tab.icon = ContextCompat.getDrawable(this@MainActivity,R.drawable.dinner)}
                    2 -> { tab.text = "Travel"
                        tab.icon = ContextCompat.getDrawable(this@MainActivity,R.drawable.travel)}
                }


            }.attach() //must call it

        }

    }
}