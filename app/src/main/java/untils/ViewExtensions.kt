package com.example.studentprofile.utils

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast

/**
 * Thư viện Extension Functions dùng chung cho toàn dự án.
 */

// --- Extension cho Context: hiển thị Toast nhanh gọn, gọi trực tiếp trong Activity ---
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// --- Extension cho EditText: lấy text đã trim, tránh lỗi khoảng trắng thừa ---
fun EditText.trimmedText(): String = this.text.toString().trim()

// --- Extension cho View: ẩn/hiện nhanh, tránh lặp code View.VISIBLE / View.GONE ---
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

// --- Extension cho Double: phân loại học lực dựa trên điểm GPA ---
fun Double.gpaClassification(): String = when {
    this >= 3.6 -> "Xuất sắc"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    this >= 2.0 -> "Trung bình"
    else -> "Yếu"
}

// --- Extension cho Double: kiểm tra GPA có nằm trong khoảng hợp lệ 0.0 - 4.0 hay không ---
fun Double.isValidGpa(): Boolean = this in 0.0..4.0