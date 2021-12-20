package com.magicworld.avantic.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.magicworld.avantic.model.Lugares
import com.magicworld.avantic.model.LugaresItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private val lugaresLoad: MutableLiveData<ArrayList<LugaresItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugaresItem>> =lugaresLoad

    fun loadMocklugaresFromJson(lugaresString: InputStream?){
        val lugareString: String = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value= gson.fromJson(lugareString, Lugares::class.java)
    }
}