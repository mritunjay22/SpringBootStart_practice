package bootStart_Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service    // Alternate We Can Use @Component
public class BusinessService {
	
private List<Subjects> subAuto =   new ArrayList<>(Arrays.asList(             // new and after arrayList to make this mutable so that we can add and remove things later
		new Subjects("1","JAVA","HELLO JAVA DEV"),
		new Subjects("2","Python","HELLO Python DEV"),
		new Subjects("3","RUBY","HELLO RUBY DEV"),
		new Subjects("4","PHP","HELLO PHP DEV")
		));
	

// it will just return the all existing element in the List
	public List<Subjects> getAllTopics(){
		return subAuto;
	}
	
	
	
	// its for Searching the whole List and finding the specific entry/ value
	public Subjects getSingleSubject(String id) {
		return	subAuto.stream().filter(t -> t.getS_no().equals(id)).findFirst().get();
			
		}
	
	
	
	//its for adding the new object/ instance/ value to the List
	public void addSubject(Subjects rec) {    // this will rec a object of Subject and will add to the above existing lIst
		subAuto.add(rec);
		System.out.println("Subject Succesfully ADDED");
		}
	
	
	// its for updating the specific index with the new Object/ instance/ valve
		public void updateSubject(Subjects forUpdate, String id) {
	    for(int i =0;i<subAuto.size();i++) {        // its goona Loop Through  every element in the List of subAuto  and find that  index id and goona update that index only
	    	Subjects s = subAuto.get(i);             // subAuto above is the List of Subjects class/POJO class
	    	if(s.getS_no().equals(id)) {        
	    		subAuto.set(i,forUpdate);    // here when we find the specific index and update that specific indexxxxxxxxx
	    		System.out.println("Subject Succesfully UPDATED");
	    		return;
	    	} 	
	    }
	
				}


     // this is to DELETE the existing entry from the List by its ID
		public void deleteSubject(String id) {
			subAuto.removeIf(t -> t.getS_no().equals(id));       //Lamda Expression
			System.out.println("Subject Succesfully REMOVED");
			
		}



}
