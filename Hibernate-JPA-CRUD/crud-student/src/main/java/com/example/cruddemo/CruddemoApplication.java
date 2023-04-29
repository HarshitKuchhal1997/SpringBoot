package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			createStudent(studentDAO);
		};
	}


	// creating and saving student into the database
	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object......");
		Student tempStudent=new Student("Harshit","Kuchhal","harshitkuchhal96@gmail.com");

		// save the object
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student... Generated ID: "+tempStudent.getID());

	}
}