package com.example.lotto2404

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lotto2404.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment1 = Fragment1()
        transaction.add(binding.container.id, fragment1)
        transaction.commit()
    }
}