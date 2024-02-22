package com.abhay.demoproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/*@Entity(tableName = "PersonTable")
data class PersonEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "age") val age: String
)*/

@Entity(tableName = "PersonTable")
class PersonEntity(
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "age") val age: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}
