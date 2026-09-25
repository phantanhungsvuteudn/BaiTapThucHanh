package com.example.studentprofile.model

/**
 * Data Class quản lý thực thể Sinh viên.
 * Dùng data class để tự động có equals(), hashCode(), toString(), và đặc biệt là copy()
 * giúp cập nhật bất biến (immutable update) mà không phá vỡ trạng thái cũ.
 */
data class Student(
    val studentId: String,
    val fullName: String,
    val className: String,
    val email: String,
    val gpa: Double
) : java.io.Serializable