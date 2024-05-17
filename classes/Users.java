package classes;

import model.User;
import interfaces.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Users implements IUsers{
	User userList[] = new User[100];

	public int userCount = 0;
	
	public Users(){
		try{
			File file = new File("file/userList.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();
					String line2 = sc.nextLine();
					String line3 = sc.nextLine();
					String line4 = sc.nextLine();
					String line5 = sc.nextLine();
					String line6 = sc.nextLine(); // for empty line
					
					String name = line1.substring(6);
					String email = line2.substring(7);
					String password = line3.substring(10);
					String gender = line4.substring(8);
					String dob = line5.substring(15);
					
					User u = new User(name,email,password,gender,dob);
					userList[userCount] = u;
					userCount++;
				}
				sc.close();   //closing the file 		
		}catch(Exception ex){
			System.out.println(ex.toString());
			return;
		}
	}

	/*public void printUser(){
		for(int i=0;i<userCount;i++){
			System.out.println(userList[i].getUserString());
		}
	}*/
	
	public int userExists(String email){
		int index = -1;
		for(int i=0;i<userCount;i++){
			if(userList[i].getEmail().equals(email)){
				index = i;
				break;
			}
		}
		return index;
	}

	public User checkCredentials(int index, String pass){
		if((userList[index].getPassword().equals(pass))){
			return userList[index];
		}else{return null;}
	}
	
	public User getUser(int index){
		return userList[index];
	}
	
	public void addUser(User u){
		//adding user in user array
		userList[userCount]=u;
		userCount++;
		
		//make the arry a string then print in the user file
		String newDetails = "";
		for(int i=0;i<userCount;i++){
			String userDetails = userList[i].getUserString() + "\n";
			newDetails += userDetails;
		}
		try{
			String filepath = "file/userList.txt";
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println("File not found.");
		}
	}
	
	
	public void updateUser(User oldUser, User updatedUser){
		//updating value in user array
		int index = userExists(oldUser.getEmail());
		if(index != -1){
			userList[index] = updatedUser;
		}

		//writing user array in the file to update file with new updated user data
		String newDetails = "";
		for(int i=0;i<userCount;i++){
			String userDetails = userList[i].getUserString();
			newDetails += userDetails + "\n";
		}
		try{
			String filepath = "file/userList.txt";
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void deleteUser(User u){
		int index = userExists(u.getEmail());
		for(int i=index;i<userCount-1;i++){
			userList[i]=userList[i+1];
		}
		--userCount;
		userList[userCount]=null;
		
		//deleted from  array now printing the array in user file
		String newDetails = "";
		for(int i=0;i<userCount;i++){
			String userDetails = userList[i].getUserString();
			newDetails += userDetails + "\n";
		}
		try{
			String filepath = "file/userList.txt";
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}