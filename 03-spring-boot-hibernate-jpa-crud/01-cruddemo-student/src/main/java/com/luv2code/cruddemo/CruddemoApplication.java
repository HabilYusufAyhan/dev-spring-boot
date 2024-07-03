package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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

		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//findByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Delete all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Deleting student id: " +studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
        int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name to "Ayşe"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Aysse");
		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student" + myStudent);
	}

	private void findByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Ayhan");
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Ali","ali@gmail.com","Ayhan");
		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " +theId);
		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);
		//display student
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Ayse","ayse@gmail.com","Ayam");
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
