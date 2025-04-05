package ir.appdroid.sb1.repository

import ir.appdroid.sb1.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student,String> {
}