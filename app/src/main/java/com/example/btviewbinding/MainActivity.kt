package com.example.btviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.btviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val name = binding.edtInputName.text.toString().trim()
            if (name.isNotEmpty()) {
                binding.tvMessage.text = "Xin chào, $name!"
                binding.edtInputName.text.clear()
            }
        }
    }
}