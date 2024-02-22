package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner (AppDAO appDAO) {

		return runner ->
		{
			//createCourseAndStudent(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Deleting Student Id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Rubik's Cube - How To Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("Associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Load Student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Load course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		System.out.println("Done!");

	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How To Score One Million Points.");

		Student tempStudent1 = new Student("Mohammad", "Alabed", "mohammad.sh.alabed@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		appDAO.saveCourse(tempCourse);

		System.out.println("Done!");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting Course Id: " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done! ");
	}

	private void retriveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		tempCourse.addReview(new Review("Great course ... love it!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		System.out.println("saving the course ...");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.saveCourse(tempCourse);

		System.out.println("Done!!!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Fining Course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating Course id: " + theId);
		tempCourse.setTitle("Enjoy the simple things");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finiding Instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Update Instructor Id: " + theId);
		tempInstructor.setLastName("Alabed");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.FindInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("The associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding Courses for instructor id: " + theId);

		List<Course> courses = appDAO.findCourseByInstructorId(theId);

		tempInstructor.setCourses(courses); // or just print the courses list no wrong or write
														// it depend on your requirement
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("the associated courses: " + tempInstructor.getCourses()); // error because
																			         // by default is
																					 // lazy

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor =
				new Instructor("Ahmad","Mosa","Ahmad@gmial.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.ahmad.com/youtube",
						"video games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;

		InstructorDetail instructorDetailTemp = appDAO.findInstructorDetailById(theId);

		System.out.println("Instructor Detail: " + instructorDetailTemp);

		System.out.println("The associated instructor: " + instructorDetailTemp.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting Instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Temp instructor: " + tempInstructor);
		System.out.println("The associate instructor only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		Instructor tempInstructor =
					new Instructor("mohammad","alabed","mohammad.sh.alabed@gmial.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.mohammad.com/youtube",
						"love 2 code!!! ");
*/

		Instructor tempInstructor =
				new Instructor("Osama","Salah","osama@gmial.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.mohammad.com/youtube",
						"Guiter");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);

		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
