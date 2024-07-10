package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
				//createCourseAndReviews(appDAO);
			    //retrieveCourseAndReviews(appDAO);
				deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());


	}
	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How the Score One Million Points");

		tempCourse.addReview(new Review("Great course ... loved it"));
		tempCourse.addReview(new Review("Cool course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot"));


		// save the course ... and leverage the cascade all

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!!");
	}
	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}
	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseById(theId);

		tempCourse.setTitle("Enjoy the Simple Things");
		appDAO.update(tempCourse);

		System.out.println("Done updating course");
	}
	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);


		System.out.println("Update instructor: " + tempInstructor);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);
		System.out.println("Done updating instructor: " + tempInstructor);

	}
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Found instructor: " + instructor);
		System.out.println("the associated courses: " + instructor.getCourses());
	}
	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());  // bu kodda tempınstructor dan çekme sebebimiz yukarıda kursları çağırarak tempınstructora verileri kaydetmiş olmamızdır
		System.out.println("Done!");
	}
	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");
	}
	private void createInstructorWithCourses(AppDAO appDAO) {
	/*Instructor instructor = new Instructor("Yusuf","Ayhan","habilyusuf20@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code!!");*/

		Instructor instructor = new Instructor("Susan","Public","susan@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Video Games");



		instructor.setInstructorDetail(instructorDetail);

		// create some courses

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		instructor.add(tempCourse1);
		instructor.add(tempCourse2);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("The courses: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");
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
