package bootStart_Controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
	@Autowired
private BusinessService businessTry;
	
	
	@RequestMapping("/mritunjay")
	public String getMritunjay() {
		return "Mritunjay";
	}
	
	// Working topics URL not trying business Service
//	@RequestMapping("/topics")
//	public List<Subjects> getSubjects(){
//		sub =  Arrays.asList(
//				new Subjects("1","JAVA","HELLO JAVA DEV"),
//				new Subjects("2","Python","HELLO Python DEV"),
//				new Subjects("3","RUBY","HELLO RUBY DEV"),
//				new Subjects("4","PHP","HELLO PHP DEV")
//				);
//		return sub;	
//	}
	
	
	//this is using a Business Service with @Service Annotation Which can be changed Later
	
	//@RequestMapping(method=RequestMethod.GET,value="/topics")        // we can Write Like this also
	@RequestMapping("/topics")       // this is GET request   GET the default request
	public List<Subjects> getSubjects(){
		return businessTry.getAllTopics();
	}
	

	// here keep the URL variableName and argument pass name same
	@RequestMapping("/topics/{id}")   ///if the variable name is different in @RequestMapping("/topics/{foo}") then we need to( @PathVariable("foo") String id)     
	public Subjects getSingleSubject( @PathVariable String id) {    // this is to tell spring that pass that above variable part to this method
		 return businessTry.getSingleSubject(id);
	}
	
	
	//Post Request
	// to insert the value
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")  // here this is how we map this for post request  this can be used for any request but GET is by default but we can write by this way also
	public void addSubject(@RequestBody Subjects sub) {    // to pick the instance from req body and add this to existing list
	// here it means your request payload goona contain a JSON representation of this Subjects instance/object 
	// here we are asking it to take that request body and convert it into Subjects  instance/Object type and pass this to addSubject method
	// when this URL is accessed
		businessTry.addSubject(sub);	
	}
	
	
	//PUT REQUEST 
	//To Update the Existing Entry
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")     
	public void updateSubject( @RequestBody Subjects forUpdate, @PathVariable String id) {
		
		businessTry.updateSubject(forUpdate,id);
		
	}
	
	
	//DELETE REQUEST
	// to DELETE the Existing Entry
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteSubject(@PathVariable String id) {
		businessTry.deleteSubject(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
}
