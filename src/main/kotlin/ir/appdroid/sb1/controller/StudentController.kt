package ir.appdroid.sb1.controller

import com.google.gson.Gson
import ir.appdroid.sb1.model.Student
import ir.appdroid.sb1.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class StudentController {

    lateinit var studentRepository: StudentRepository

    @Autowired
    fun set_student_repository(studentRepo: StudentRepository) {
        studentRepository = studentRepo
    }

    @GetMapping("/student")
    fun getAllStudents(): ResponseEntity<ArrayList<Student>> {
        val dataFromDatabase = studentRepository.findAll()
        val dataArrayList = ArrayList<Student>()

        dataFromDatabase.forEach {
            dataArrayList.add(it)
        }
        return ResponseEntity.ok(dataArrayList)
    }

    @PostMapping("/student")
    fun insertStudent(@RequestBody data: String): ResponseEntity<String> {
        val gson = Gson()
        val newStudent = gson.fromJson<Student>(data, Student::class.java)

        studentRepository.save(newStudent)

        return ResponseEntity.ok("success")
    }

    @PutMapping("student/updating{name}")
    fun updateStudent(
        @PathVariable("name") name: String,
        @RequestBody data: String
    ): ResponseEntity<String> {
        val gson = Gson()
        val newStudent = gson.fromJson(data, Student::class.java)

        studentRepository.save(newStudent)

        System.out.println(name)

        return ResponseEntity.ok("success")
    }

    @DeleteMapping("student/deleting{name}")
    fun deleteStudent(@PathVariable("name") name: String): ResponseEntity<String> {

        studentRepository.deleteById(name)
        return ResponseEntity.ok(name)
    }
}