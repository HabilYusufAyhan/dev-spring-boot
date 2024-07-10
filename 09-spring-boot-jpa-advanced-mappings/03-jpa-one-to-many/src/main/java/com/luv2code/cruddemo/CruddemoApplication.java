package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		appDAO.deleteInstructorById(2);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 3;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);


		// print the instructor detail

		System.out.println(instructorDetail);
		// print the associated instructor

		System.out.println(instructorDetail.getInstructor());
	}


	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void createInstructor(AppDAO appDAO) {
		/*Instructor instructor = new Instructor("Yusuf","Ayhan","habilyusuf20@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code!!");*/

		Instructor instructor = new Instructor("Emre","Aydin","emre@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Guitar");



		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}
}
