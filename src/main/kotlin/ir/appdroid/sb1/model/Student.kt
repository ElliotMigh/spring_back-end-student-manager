package ir.appdroid.sb1.model

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id

@Entity
data class Student(

    @jakarta.persistence.Id
    var name: String,

    var course: String,
    var score: Int
){
    constructor() : this("","",-1)
}