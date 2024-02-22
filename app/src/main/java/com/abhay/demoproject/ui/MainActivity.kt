package com.abhay.demoproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.abhay.demoproject.BuildConfig
import com.abhay.demoproject.R
import com.abhay.demoproject.databinding.ActivityMainBinding
import com.abhay.demoproject.db.PersonEntity
import com.abhay.demoproject.util.hideKeyboard


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MainViewModel::class.java)

        binding.btnSubmit.setOnClickListener {

            binding.btnSubmit.hideKeyboard()

            val firstname = binding.etFirstName.text.toString()
            val lastname = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val age = binding.etAge.text.toString()

            val person = PersonEntity(firstname, lastname, email, age)

            Log.d("submit", "onCreate: ${person.firstName}")

            when (BuildConfig.FLAVOR) {
                "Room" -> {
                    viewModel.storeInRoomDB(person)
                }

                "SF" -> {
                    viewModel.storeInSF(person)
                }

                else -> {

                }
            }
            binding.etAge.clearFocus()
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etEmail.text.clear()
            binding.etAge.text.clear()


        }


    }
}