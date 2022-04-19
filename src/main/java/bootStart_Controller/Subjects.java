package bootStart_Controller;

public class Subjects {
private String s_no;
private String sub;
private String des;


//POJO CLASS TO RETURN LIST OF OBJECTS OF SUBJECTS




public Subjects() {
	//Default
}


public Subjects(String s_no, String sub, String des) {
	super();
	this.s_no = s_no;
	this.sub = sub;
	this.des = des;
}
public String getS_no() {
	return s_no;
}
public void setS_no(String s_no) {
	this.s_no = s_no;
}
public String getSub() {
	return sub;
}
public void setSub(String sub) {
	this.sub = sub;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}


}
