# SpringBootStart_practice
This is the Spring boot RestApi Start Project Using Hard Coded Values



Ways to Create SpringBoot Application 1)Spring initializr 2) Spring Boot CLI 3) STS IDE
To make changes to Spring Boot Application Default Properties we Configure it by application.properties under src/main/resources
lets Start
Lets add a controller
a java class
with Marked with annotations
Has info About ------------- what URL access trigrers it?
                             What method to run when accessed?
                             
     
     //How to Tell Spring that this is the Spring Application?
       @SpringBootApplication  //it is used to tell spring that this is the spring application and start from here
          
                             
                             
 @RestController
 //@RestController Annotation is put to any class to tell spring that this class act as a Rest Controller
 inside it 
 To control the URL patterns
 it consist of multiple method to control the URL actions and Request
 
 
 ____________________________________________Use a class As Service/Component_________________________________________________
 # it is used to declare the class or use a class as service/ or we can say a seprate Data Hold container So further Changes can be made without disturbing the other component
 to Declare a Service We can use Either @Service or @Component both can be used
 We Just have to Wite this annotation above the Service class to tell spring that this class act as Service
 Example
 We Used BusinessService class as a Service in this proj
 Syntax    
 			@Service    // Alternate We Can Use @Component
				public class BusinessService {
			
				}
 
  ______________________________________________________GET request_____________________________________________________
  #By default mode
 
 @RequestMapping("/URLNAME")
 // it tells the spring to execute this block of code when user user request /hello ,  
 // By default RequestMapping("/URL NAME") maps only to the Get Method by default 
  // For  other http request specify it in the annotation
 
 
 
 IMPORTANT POINTS
 Embedded Tomcat Server
 
 * Convenience
 * Servlet Container config is now application config
 * We don't need to interact with Servlet and load the things Spring take care of these things
 * Standalone Application  because of Embedded Tomcat short less code controllers 
 * it runs like a simple Java Appllication with all important logic and with database
 * Easy to Deploy
 * Useful for Microservices architecture
 
 
 
 
 
 
 @RequestMapping("/topics/{variableName}")
 this is to tell spring that the {} part is an variable in URL and its value can varry according to input
 
 but here the important part is how we can tell spring that to pass that Variable part to the mapped method so we do this using another annotation 
  eg
  	public Subjects getSingleSubject( @PathVariable String id) {    // this is to tell spring that pass that above variable part to this method
		 return businesstry.getSingleSubject(id);
	}
  
  NOTE HERE @PathVariable annotation is used to PASS THAT URL VARIABLE TO THE MAPPED METHOD 
  just write @PathVariable in front of variable passed then it will tell spring to pass that path variable to mapped method
  
  
  //if the variable name is different in @RequestMapping("/topics/{foo}") then we need to( @PathVariable("foo") String id) in request mapping method
  
  
  PostMan eg 
  URL: http://localhost:8080/topics     // for all existing entry
  
  URL: http://localhost:8080/topics/3      // for specific entry after / that is the id number of that entry that you want to see
  ______________________________________________upto here is the GET request__________________________________________
  
  
  CHILL BROOOOOOO!!!!!!!
  EVERYTHING WILL BE ALRIGHT  KT
  IMP IN PostMan in body Section Raw we have to write the json object/ valve
  and in Header Section We have to select key as Content-Type   and value as  application/json
  it will tell that this is the json object 
  we use this in POST, PUT request
  We are writing all the logic at BusinessService Class because it is the main class which contain the data/entry
  
  
  ________________________________________________________POST request_________________________________________________________
  
  
  #To add the new entry
  # create new topics
  # this is the post request 
  eg
  @RequestMapping(method=RequestMethod.POST, value="/topics")  // here this is how we map this for post request  this can be used for any request but GET is by default but we can write by this way also
	public void addTopics(@RequestBody Subjects sub) {	      // to insert it accept the single Subjects object/ instance to add 
	businessTry.addSubject(sub);                              // by @RequestBody annotation is pass the json object from spring mvc to to this method as an instance / object
	}
	HERE in value the URL are of post request
	
	
	Now when we want to make a post request and add that in existing list
	HERE WE USE POST REQUEST
	USE POSTMAN FOR THIS WORK
	
		@RequestMapping(method=RequestMethod.POST, value="/topics")  // here this is how we map this for post request  this can be used for any request but GET is by default but we can write by this way also
	public void addSubject(@RequestBody Subjects sub) {    // to pick the instance from req body and add this to existing list
	// here it means your request payload goona contain a JSON representation of this Subjects instance/object 
	// here we are asking it to take that request body and convert it into Subjects  instance/Object type and pass this to addSubject method
	// when this URL is accessed
		businesstry.addSubject(sub);
		
	}
	
	THIS WILL CONVERT YOUR JSON REPRESENTATION TO Subjects instance/object by Spring mvc and by @RequestBody it will be passed to 
	
	PostMan eg
	URL: http://localhost:8080/topics
	in Body: {
    		"s_no": "5",
    		"sub": "C++",
    		"des": "HELLO C++ DEV"
			}

in Headers : key= Content-Type  value = application/json
	
	
	
_____________________________________________________________PUT request_____________________________________________________
	 #it Update the Existing Entry   // Data Update
	 
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateSubject( @RequestBody Subjects forUpdate,@PathVariable String id) {
		
		businessTry.updateSubject(forUpdate,id);
		
	}
	
	HERE FOR JSON REPRESENTATION TO Subjects instance/object by Spring mvc we have to use @RequestBody and for URL variable we use @PathVariable  
	For Put request we need two things 1) the updated instance/object/value   2) that index / object id in which we have to update 
	so thats why  this Function contain two parameter
	
	
	PostMan eg
	URL:  http://localhost:8080/topics/6   // because that specific entry we want to update 
	in Body :  {
    			"s_no": "6",
    			"sub": " Updated HTML",
   				 "des": "Updated HELLO HTML DEV"
				}
	
	in Headers : key= Content-Type  value = application/json
	
	
	 
	__________________________________________________________DELETE request_____________________________________________________
	 
	 #to delete the Existing entry / value in instance
	 # This will delete the Existing entry by its id
	 
	 
	 //DELETE REQUEST
	// to DELETE the Existing Entry
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteSubject(@PathVariable String id) {
		businessTry.deleteSubject(id);	
	}
	
	
	
IN CONTROLLER CLASS

// this is to DELETE the existing entry from the List by its ID
		public void deleteSubject(String id) {
			subAuto.removeIf(t -> t.getS_no().equals(id));     //Lamda Expression
			System.out.println("Subject Succesfully REMOVED");
		}
	 
	 
	 PostMan eg
	URL:  http://localhost:8080/topics/6   // because that specific entry we want to DELETE
	
	in Headers : key= Content-Type  value = application/json
	
	
	
	######################################CRUD OPERATIONS ARE IN springboot_database_operations with same package and class controllers########################
	GOODLUCK!!!!!!!!!!!
	
   
