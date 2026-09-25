package com.example.studentprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityMainBinding
import com.example.studentprofile.model.Student
import com.example.studentprofile.utils.gpaClassification
import com.example.studentprofile.utils.isValidGpa
import com.example.studentprofile.utils.toast
import com.example.studentprofile.utils.trimmedText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val defaultStudent = Student(
        studentId = "21115053120316",
        fullName = "Phan Tấn Hùng",
        className = "21LTDD02",
        email = "hung.pt@ute.udn.vn",
        gpa = 3.75
    )

    // 'var' vì trạng thái sinh viên có thể thay đổi khi người dùng cập nhật điểm
    private var currentStudent = defaultStudent

    companion object {
        private const val KEY_STUDENT = "KEY_STUDENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khôi phục trạng thái nếu vừa xoay màn hình / Activity bị hệ thống tái tạo
        savedInstanceState?.getSerializable(KEY_STUDENT)?.let {
            currentStudent = it as Student
        }

        bindStudentData(currentStudent)

        // Sự kiện: Cập nhật điểm GPA
        binding.btnUpdateGpa.setOnClickListener {
            val gpa = binding.edtGpaInput.trimmedText().toDoubleOrNull()

            // Validate dữ liệu phòng thủ
            if (gpa == null || !gpa.isValidGpa()) {
                binding.edtGpaInput.error = "GPA phải từ 0.0 đến 4.0"
                return@setOnClickListener
            }

            // Cập nhật bất biến bằng copy(), không sửa trực tiếp thuộc tính
            currentStudent = currentStudent.copy(gpa = gpa)
            bindStudentData(currentStudent)
            binding.edtGpaInput.text?.clear()
            toast("Đã cập nhật GPA thành công!")
        }

        // Sự kiện: Khôi phục mặc định
        binding.btnReset.setOnClickListener {
            currentStudent = defaultStudent
            bindStudentData(currentStudent)
            binding.edtGpaInput.text?.clear()
            toast("Đã khôi phục hồ sơ mặc định")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Bảo toàn trạng thái khi xoay màn hình
        outState.putSerializable(KEY_STUDENT, currentStudent)
    }

    /**
     * Hàm dùng chung để đổ dữ liệu Student lên toàn bộ giao diện.
     * Được tái sử dụng cho: khởi tạo, sau khi xoay màn hình, và sau mỗi lần cập nhật.
     */
    private fun bindStudentData(student: Student) = with(binding) {
        tvStudentName.text = student.fullName
        tvStudentId.text = "MSSV: ${student.studentId}"
        tvClassName.text = "Lớp: ${student.className}"
        tvEmail.text = student.email
        tvGpaBadge.text = "%.2f GPA (%s)".format(student.gpa, student.gpa.gpaClassification())
    }
}