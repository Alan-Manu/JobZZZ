package com.example.jobzz.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.example.jobzz.databinding.ActivityDetailJobBinding
import com.example.jobzz.fragment.AboutFragment
import com.example.jobzz.fragment.CompanyFragment
import com.example.jobzz.fragment.ReviewFragment
import com.example.jobzz.model.JobModel

class DetailJobActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailJobBinding
    private lateinit var  item:JobModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundle()
        setupViewpager()

    }

    private fun getBundle() {
        item=intent.getParcelableExtra("object")!!

        binding.titleTxt.text= item.title
        binding.companyTxt.text=item.company
        binding.locationTxt.text=item.location
        binding.jobtypetxt.text=item.time
        binding.workingmodeltxt.text=item.model
        binding.leveltxt.text=item.level
        binding.salarytxt.text=item.salary

        val drawableResourceId = resources.getIdentifier(item.picUrl,"drawable",packageName)

        Glide.with(this)
            .load(drawableResourceId)
            .into(binding.picDetail)

        binding.backbtn.setOnClickListener{
            finish()
        }
    }
    private fun setupViewpager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        val tab1 =AboutFragment()
        val tab2 =CompanyFragment()
        val tab3 =ReviewFragment()

        val bundle1=Bundle()
        bundle1.putString("description",item.description)
        bundle1.putString("about",item.about)

        tab1.arguments=bundle1
        tab2.arguments= Bundle()
        tab3.arguments= Bundle()

        adapter.addFrag(tab1,"About")
        adapter.addFrag(tab2,"Company")
        adapter.addFrag(tab3,"Review")

        binding.viewpager.adapter=adapter
        binding.tabslayout.setupWithViewPager(binding.viewpager)
    }
    private class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){
        private val fragmentList = arrayListOf<Fragment>()
        private val fragmentTitleList = arrayListOf<String>()
        override fun getCount(): Int = fragmentList.size

        override fun getItem(position: Int): Fragment =fragmentList[position]

        fun addFrag(fragment: Fragment,title:String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence = fragmentTitleList[position]

    }
}