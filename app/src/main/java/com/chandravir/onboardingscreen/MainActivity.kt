package com.chandravir.onboardingscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.chandravir.onboardingscreen.Adapter.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter : ViewPagerAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val relativeLayout = findViewById<RelativeLayout>(R.id.layout)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)

        val btnContinue = findViewById<Button>(R.id.btnContinue)

        val animationDrawable = relativeLayout.background as AnimationDrawable
        addAnimation(animationDrawable)

        viewPager = findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        dotsIndicator.attachTo(viewPager)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
//                Log.i("Tag", position.toString())
                if (position == 0){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation123)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.INVISIBLE
                }
                if (position == 1){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation456)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.INVISIBLE
                }
                if (position == 2){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_animation789)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.VISIBLE
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        btnContinue.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

        }
    }

    fun addAnimation(animationDrawable: AnimationDrawable){
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1500)
        animationDrawable.start()
    }

}