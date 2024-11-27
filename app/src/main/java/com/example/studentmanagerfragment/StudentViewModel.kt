package com.example.studentmanagerfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentmanagerfragment.models.StudentModel

class StudentViewModel : ViewModel() {
    val students = MutableLiveData<MutableList<StudentModel>>()

    init {
        students.value = mutableListOf(
            StudentModel("Nguyen Van A", "SV001"),
            StudentModel("Tran Thi B", "SV002")
        )
    }

    fun saveStudent(student: StudentModel, position: Int?) {
        val currentList = students.value ?: mutableListOf()

        if (position != null && position >= 0) {
            // Edit existing student
            currentList[position] = student
        } else {
            // Add new student
            currentList.add(student)
        }

        students.value = currentList
    }
}
