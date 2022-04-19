package bootStart_Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//How to Tell Spring that this is the Spring Application?
@SpringBootApplication  //answer
public class CourseApiApp {

	public static void main(String[] args) {
	 //we need to tell Spring to use this as a application\
		// load this in Servlet Container 
		// and make it Available
		// Its Stand Alone Application Because it already Contain all required Things
		// Its Stand Alone Application Because it can be run like a Simple JAVA CLASS
		//For all this Above Work a Simple class is there in Spring boot it is static class
		SpringApplication.run(CourseApiApp.class, args);  // static method of static class  argument(SpringbootApplicationClass,argument passed to that perticular main class)
		
		
		

	}

}
//what @SpringBootApplication Does
//1)  Sets up default Configuration
//2) Starts Spring application context
//3)Performs class path scan
//4) Starts Tomcat Server

// Thats why its a stand alone application