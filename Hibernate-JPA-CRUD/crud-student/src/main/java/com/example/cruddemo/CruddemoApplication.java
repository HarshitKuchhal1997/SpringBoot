package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			//createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudent(studentDAO);

			queryForStudentByLastName(studentDAO);
		};
	}

	// ------------------ Read multiple/all Students from the Database based on last name filter ----------------------

	private void queryForStudentByLastName(StudentDAO studentDAO) {


		// get a list of students
		List<Student> theStudent=studentDAO.findByLastName("Pandey");

		// display list of student
		for (Student tempStudent:theStudent){
			System.out.println(tempStudent);
		}
	}

	// ------------------ Read multiple/all Students from the Database ----------------------

/*

	private void queryForStudent(StudentDAO studentDAO) {

		// get the List of Students stored in the database
		List<Student> theStudent=studentDAO.findAll();

		// display all the students
		for (Student tempStudent:theStudent){
			System.out.println(tempStudent);
		}

	}

*/




	// ------------------ Read single Student from the Database ----------------------

/*
	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating new students object......");
		Student tempStudent=new Student("Priyanka","Sharma","sharma.priyanka95@gmail.com");

		// save the student
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int student_Id=tempStudent.getID();
		System.out.println("Saved student."+"\t"+"Generated ID: "+student_Id);

		// retrieve student based on the id( which is primary key in our case)
		System.out.println("Retrieving student with ID"+student_Id);
		Student myStudent=studentDAO.findById(student_Id);

		// display student
		System.out.println("Found the Student."+"\t"+myStudent);
	}

*/


		//--------------- FOR MULTIPLE ENTRY INTO THE DATABASE -------------------
/*
	// creating and saving multiple student into the database
	private void createMultipleStudent(StudentDAO studentDAO) {

		// create student object for single
		System.out.println("Creating new students object......");
		Student tempStudent1=new Student("Harshit","Kuchhal","harshitkuchhal96@gmail.com");
		Student tempStudent2=new Student("Kriti","Kuchhal","krititkuchhal98@gmail.com");
		Student tempStudent3=new Student("Ruhi","Pandey","ruhi.pandey97@gmail.com");
		Student tempStudent4=new Student("Simran","Gupta","simran_gupta96@gmail.com");

		// save the object for single
		System.out.println("Saving the student.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

		// display id of the saved student for single
		System.out.println("Saved 1st student."+"\t"+"Generated ID: "+tempStudent1.getID()+"\n"+"Saved 2nd student."+"\t"+"Generated ID: "+tempStudent2.getID()+"\n"+"Saved 3rd student."+"\t"+"Generated ID: "+tempStudent3.getID()+"\n"+"Saved 4rd student."+"\t"+"Generated ID: "+tempStudent4.getID());

	}

*/
		// ------------------- FOR SINGLE ENTRY INTO THE DATABASE--------------------
/*

	// creating and saving single student into the database
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

 */
}