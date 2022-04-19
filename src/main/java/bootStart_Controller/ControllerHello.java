package bootStart_Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHello {

	
	//@RestController Annotation is put to any class to tell spring that this class act as a Rest Controller
	
	
	
		// Get request is Default
		@RequestMapping("/hello")      // it tells the spring to execute this block of code when user user request /hello ,  
		public String sayHi()   // By default RequestMapping("/URL NAME") maps only to the Get Method by default 
		{                        // For  other http request specify it in the annotation
			
			
			return "Hello Autobot";
		}
		
		
		
		@RequestMapping("/kt")
		public String testController() {
			return "KT";
		}
		
	
	
}
