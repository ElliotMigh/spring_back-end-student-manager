package ir.appdroid.sb1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class Sb1Application

fun main(args: Array<String>) {
	runApplication<Sb1Application>(*args)
}
//MVC
//Model => database (repository)   StudentRepository
//View => HTML, Json Restfull
//Controller => Controller         Student controller

