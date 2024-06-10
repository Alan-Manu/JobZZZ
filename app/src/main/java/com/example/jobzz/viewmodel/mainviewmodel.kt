package com.example.jobzz.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.jobzz.repository.Mainrepository


class mainviewmodel(val respository: Mainrepository):ViewModel(){
    constructor():this(Mainrepository())

    fun loadLocation()=respository.location

    fun loadCategory()=respository.category

    fun loadData() = respository.items
}