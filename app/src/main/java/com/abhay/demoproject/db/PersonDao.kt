package com.abhay.demoproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PersonDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(person: PersonEntity)


}