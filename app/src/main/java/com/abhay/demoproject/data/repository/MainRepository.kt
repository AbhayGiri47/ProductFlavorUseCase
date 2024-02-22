package com.abhay.demoproject.data.repository

import android.util.Log
import com.abhay.demoproject.db.PersonDao
import com.abhay.demoproject.db.PersonEntity
import com.abhay.demoproject.util.CommonSharedPref

class MainRepository(private val personDao: PersonDao) {

    fun storeInRoomDB(personEntity: PersonEntity) {
        personDao.insert(personEntity)
    }

    fun storeInSF(personEntity: PersonEntity) {

        CommonSharedPref.putString("fn",personEntity.firstName)
        CommonSharedPref.putString("ln",personEntity.lastName)
        CommonSharedPref.putString("email",personEntity.email)
        CommonSharedPref.putString("age",personEntity.age)

        val fn = CommonSharedPref.getString("fn")


    }
}