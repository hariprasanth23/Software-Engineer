package com.learn.aopdemo;

import com.learn.aopdemo.dao.StudentDAO;
import com.learn.aopdemo.entity.Student;
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

	// once all the bean have been initialized at last this will execute
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			//findStudent(studentDAO);

			//findAllStudent(studentDAO);
			
			//findAllSortByLastName(studentDAO);
			
			//findByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int studentId = studentDAO.deleteAll();
		System.out.println("Total no of deleted Students--> "+studentId);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
		System.out.println("Deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findByID(studentId);
		student.setFirstName("ScoobyDoo");
		studentDAO.update(student);
		System.out.println("updated");
	}

	private void findByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Prasanth4");
		studentList.forEach(System.out::println);
	}

	private void findAllSortByLastName(StudentDAO studentDAO) {
		System.out.println("Finding all Students sort by last Name Ascending");
		List<Student> studentList = studentDAO.findAllSortByLastName();
		System.out.println("Printing all Students");
		studentList.forEach(System.out::println);
	}

	private void findAllStudent(StudentDAO studentDAO) {
		System.out.println("Finding all Students");
		List<Student> studentList = studentDAO.findAll();
		System.out.println("Printing all Students");
		studentList.forEach(System.out::println);
	}

	private void findStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student Object");
		Student tempStudent = Student.builder().firstName("Hari4").lastName("Prasanth4").email("hari4@gmail.com").build();
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		System.out.println("StudentID"+tempStudent.getId());
		Student student = studentDAO.findByID(tempStudent.getId());
		System.out.println("retrieving the Student-->"+student);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		System.out.println();
		System.out.println("Creating 3 Student Object");
		Student tempStudent2 = Student.builder().firstName("Hari2").lastName("Prasanth2").email("hari2@gmail.com").build();
		Student tempStudent3 = Student.builder().firstName("Hari3").lastName("Prasanth3").email("hari3@gmail.com").build();
		Student tempStudent4 = Student.builder().firstName("Hari4").lastName("Prasanth4").email("hari4@gmail.com").build();
		System.out.println("Saving 3 Student Object");
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student Object");
		Student tempStudent = Student.builder()
				.firstName("Hari")
				.lastName("Prasanth")
				.email("hari1@gmail.com").build();
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		System.out.println("Saved student"+tempStudent.getId());
	}

}
