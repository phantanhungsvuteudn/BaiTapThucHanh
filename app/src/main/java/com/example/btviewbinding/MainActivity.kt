package com.example.btviewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.btviewbinding.databinding.ActivityMainBinding
import com.example.btviewbinding.utils.gone
import com.example.btviewbinding.utils.show
import com.example.btviewbinding.utils.toAcademicRanking
import com.example.btviewbinding.utils.toast
import com.example.btviewbinding.utils.trimmedText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toast("Chào mừng bạn tới ứng dụng!")

        binding.btnSubmit.setOnClickListener {
            val inputName = binding.edtInputName.trimmedText()

            if (inputName.isNotEmpty()) {
                binding.tvMessage.text = "Xin chào, $inputName!"

                val sampleGpa = 4.0
                binding.tvMessage.append("\nHọc lực mô phỏng: ${sampleGpa.toAcademicRanking()}")


                binding.edtInputName.gone()
                binding.btnSubmit.gone()
            } else {
                toast("Vui lòng nhập họ tên!")
            }
        }
    }
}