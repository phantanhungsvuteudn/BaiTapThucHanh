package com.example.btviewbinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.btviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }


        with(binding) {
            tvMessage.text = "Chào mừng bạn đến với Android Kotlin!"
            btnSubmit.text = "Gửi thông tin"
            edtInputName.hint = "Mời bạn nhập họ tên tại đây..."
        }

        binding.btnSubmit.setOnClickListener {
            handleFormSubmission()
        }
    }

    private fun handleFormSubmission() {

        val inputName = binding.edtInputName.text?.toString()?.trim()


        inputName?.takeIf { it.isNotEmpty() }?.let { validName ->


            with(binding) {
                tvMessage.text = "Xin chào, $validName!"
                edtInputName.text.clear()
            }


            validName.also { name ->
                Log.d("USER_LOG", "Người dùng đã nhập tên thành công: $name")
            }.also { name ->
                showToast("Đã ghi nhận tên: $name")
            }

        } ?: run {

            showToast("Vui lòng nhập tên trước khi bấm nút!")
        }
    }

    // Hàm hiển thị Toast hỗ trợ rút gọn mã nguồn
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}