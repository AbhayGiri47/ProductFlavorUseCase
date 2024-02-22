package com.abhay.demoproject.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abhay.demoproject.data.repository.MainRepository
import com.abhay.demoproject.db.PersonDatabase
import com.abhay.demoproject.db.PersonEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MainRepository

    init {
        val dao = PersonDatabase.getInstance(application).personDao()
        repository = MainRepository(dao)

    }

    fun storeInRoomDB(personEntity: PersonEntity)= viewModelScope.launch(Dispatchers.IO) {
        repository.storeInRoomDB(personEntity)
    }

    fun storeInSF(personEntity: PersonEntity)=viewModelScope.launch(Dispatchers.IO) {
        repository.storeInSF(personEntity)
    }

}