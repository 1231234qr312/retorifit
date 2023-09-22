package com.example.picture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.picture.databinding.ActivityMainBinding
import retrofit2.http.GET


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            changeFragment()
        }
        binding.button2.setOnClickListener {
            changeFragment2()
        }



    }

    private fun changeFragment(){
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, search())
        transaction.commit()
    }
    private fun changeFragment2(){
        val transaction=supportFragmentManager.beginTransaction()
            .replace(R.id.fragment,save())
        transaction.commit()
    }

}