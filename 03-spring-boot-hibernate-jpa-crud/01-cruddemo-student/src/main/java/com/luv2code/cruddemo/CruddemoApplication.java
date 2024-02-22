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
	@Bean                                     // inject studentDAO
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents (studentDAO);

			//readStudents(studentDAO);

			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students ...");
		int numberOfRowDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numberOfRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;

		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Update student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Deo");

		for(Student tempStudents: theStudents) {
			System.out.println(tempStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudetns = studentDAO.findAll();

		for (Student tempStudent : theStudetns) {
			System.out.println(tempStudent);
		}
	}

	//auto-inject
	private void readStudents(StudentDAO studentDAO) {
		System.out.println("Creating new object ...");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Find the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students object ...");
		Student tempStudent1 = new Student("John","Deo","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

		System.out.println("Saving students object ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Create student object ...");
		Student tempStudent = new Student("Paul","Deo","paul@luv2code.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
