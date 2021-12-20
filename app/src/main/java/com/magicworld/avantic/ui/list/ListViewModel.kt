package com.magicworld.avantic.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.magicworld.avantic.data.LugaresRepository
import com.magicworld.avantic.model.Lugares
import com.magicworld.avantic.model.LugaresItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private val lugaresLoad: MutableLiveData<ArrayList<LugaresItem>> = MutableLiveData()
    val onLugaresLoaded: LiveData<ArrayList<LugaresItem>> =lugaresLoad

    private val repository = LugaresRepository()

    fun getLugaresFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            lugaresLoad.postValue(repository.getlugares())
        }
    }

    fun loadMocklugaresFromJson(lugaresString: InputStream?){
        val lugareString: String = lugaresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value= gson.fromJson(lugareString, Lugares::class.java)
    }
}