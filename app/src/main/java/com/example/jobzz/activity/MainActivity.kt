package com.example.jobzz.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobzz.R
import com.example.jobzz.adapter.Categoryadapter
import com.example.jobzz.adapter.JobAdapter
import com.example.jobzz.databinding.ActivityIntroBinding
import com.example.jobzz.databinding.ActivityMainBinding
import com.example.jobzz.model.JobModel
import com.example.jobzz.viewmodel.mainviewmodel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel:mainviewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initLocation()
        initRecyclerViewCat()
        initRecyclerViewsuggest()
        initRecyclerViewrecent("0")

        }

    private fun initRecyclerViewrecent(cat:String) {
        var data: List<JobModel>
        if (cat == "0"){
            data =mainViewModel.loadData().sortedBy { it.category }
        }else{
            data =mainViewModel.loadData().filter { it.category ==cat }
        }
        binding.viewrecent.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewrecent.adapter =JobAdapter(data)
    }


    private fun initRecyclerViewsuggest() {
        binding.progressBarsuggest.visibility = View.VISIBLE
        binding.viewsuggested.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewsuggested.adapter = JobAdapter(mainViewModel.loadData())
        binding.progressBarsuggest.visibility = View.GONE
    }

    private fun initLocation() {
        val adapter = ArrayAdapter(this,R.layout.spinner_item,mainViewModel.loadLocation())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.locationspinner.adapter = adapter
    }

    private fun initRecyclerViewCat() {
        binding.progressBarcategoty.visibility = View.VISIBLE
        binding.viewcategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.viewcategory.adapter =
            Categoryadapter(mainViewModel.loadCategory(), object : Categoryadapter.ClickListener {
                override fun onClkick(category: String) {
                    initRecyclerViewrecent(category)
                }
            })
        binding.progressBarcategoty.visibility =View.GONE
    }
    }

