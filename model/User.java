package model;
import java.lang.*;

public class User{
	String name;
	String email;
	String password;
	String gender;
	String dob;
	
	
	public User(String name,String email, String password, String gender,String dob){
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setDOB(String dob){
		this.dob = dob;
	}
	
	
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	public String getGender(){
		return gender;
	}
	public String getDOB(){
		return dob;
	}
	public String getEmail(){
		return email;
	}

	public String getUserString(){
		String userDetails="Name: "+ getName() + "\n";
		userDetails+="Email: "+ getEmail() + "\n";
		userDetails+="Password: "+ getPassword() + "\n";
		userDetails+="Gender: "+ getGender() + "\n";
		userDetails+="Date of birth: "+ getDOB() + "\n";

		return userDetails;
	}
}