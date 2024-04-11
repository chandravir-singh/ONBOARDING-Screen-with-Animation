package com.chandravir.onboardingscreen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.chandravir.onboardingscreen.R

class ViewPagerAdapter(val context : Context) : PagerAdapter() {

    var layoutInflater : LayoutInflater ?= null

    //Arrays of image, head, description

    val imageArray = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )

    val headArray = arrayOf(
        "Heading 1",
        "Heading 2",
        "Heading 3"
    )

    val descriptionArray = arrayOf(
        "Description 1",
        "Description 2",
        "Description 3 "
    )

    override fun getCount(): Int {
        return headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {



        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)

        val image = view.findViewById<ImageView>(R.id.image)
        val txt_head = view.findViewById<TextView>(R.id.txtHeading)
        val txt_description = view.findViewById<TextView>(R.id.txtDescription)

        image.setImageResource(imageArray[position])
        txt_head.text = headArray[position]
        txt_description.text = descriptionArray[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}