package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Student {
	
	String name,fathersName,mothersName,dateOfBirth,address,phoneNumber,resNo,roll,cgpa;
	
	ArrayList<Personal> listOfPersonalInfo;
	ArrayList<Academic>listOfAcademicInfo;
	
	Scanner cin = new Scanner(System.in);
	
	public Student () {
				
		listOfPersonalInfo = new ArrayList<Personal>();
		listOfAcademicInfo = new ArrayList<Academic>();
		
		personalInfo();
		academicInfo();
		
	}
	
	public void addStudentInfo() {
		
		System.out.println("Personal Infomation - ");
		
		System.out.print("Name : ");
		name = cin.nextLine();
		
		System.out.print("Father\'s Name : ");
		fathersName = cin.nextLine();
		
		System.out.print("Mother\'s Name : ");
		mothersName = cin.nextLine();
		
		System.out.print("Date of Birth : ");
		dateOfBirth = cin.nextLine();
		
		System.out.print("Address : ");
		address = cin.nextLine();
		
		System.out.print("Phone Number : ");
		phoneNumber = cin.nextLine();
		
		System.out.print("Registration No. : ");
		resNo = cin.nextLine();
		
		System.out.print("Roll No. : ");
		roll = cin.nextLine();
		
		System.out.print("CGPA : ");
		cgpa = cin.nextLine();
		
		
		Personal p = new Personal(name,fathersName,mothersName,dateOfBirth,address,phoneNumber);
		Academic a = new Academic(name,resNo,roll,cgpa);
		
		
		try {
            
			listOfPersonalInfo.clear();
			
			ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("Personal.txt"));
            
            ArrayList<Personal> tempListOfPersonalInfo = 
                    (ArrayList<Personal>) ois.readObject();
            
            for (Personal deserializePersonalInfo : tempListOfPersonalInfo){
            	
            	listOfPersonalInfo.add(deserializePersonalInfo);
            }
            
            listOfPersonalInfo.add(p);
            
            FileOutputStream fos = new FileOutputStream("Personal.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listOfPersonalInfo);
            oos.flush();

        } catch (IOException ex) {
        	System.out.println("ObjectOutputStream in " + ex.toString());
        } catch (ClassNotFoundException ex) {
        	System.out.println("ClassNotFoundException in " + ex.toString());
        }
		
		try {
            
			listOfAcademicInfo.clear();
			
			ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("Academic.txt"));
            
            ArrayList<Academic> tempListOfAcademicInfo = 
                    (ArrayList<Academic>) ois.readObject();
            
            for (Academic deserializeAcademicInfo : tempListOfAcademicInfo){
                listOfAcademicInfo.add(deserializeAcademicInfo);
            
            }
            

            listOfAcademicInfo.add(a);
            
            FileOutputStream fos = new FileOutputStream("Academic.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(listOfAcademicInfo);
            oos.flush();
            

        } catch (IOException ex) {
        	System.out.println("ObjectOutputStream in " + ex.toString());
        } catch (ClassNotFoundException ex) {
        	System.out.println("ClassNotFoundException in " + ex.toString());
        }
		
		
	}
	
	
	
	
	public void personalInfo() {
        
		initializePersonalInfo();
    
        FileOutputStream fout = null;
        ObjectOutputStream object_out_for_serializable = null;
        try {
            fout = new FileOutputStream("Personal.txt");
            object_out_for_serializable = new ObjectOutputStream(fout);
            
            object_out_for_serializable.writeObject(listOfPersonalInfo);
            object_out_for_serializable.flush();
                    
        } catch (FileNotFoundException ex) {
            System.out.println("FileOutputStream in " + ex.toString());
        } catch (IOException ex) {
            System.out.println("ObjectOutputStream in " + ex.toString());
        } 
	}
	
	public void initializePersonalInfo() {
		
		Personal p1 = new Personal("Dip Saha","Mr. Saha","Mrs. Saha","22-03-1999",
				"Kishorganj","01629291563");
		listOfPersonalInfo.add(p1);
		
		Personal p2 = new Personal("Redowan Mahmud","Mr. Mahmud","Mrs. Mahmud","12-05-1999",
				"Sirajganj","01845657898");
		listOfPersonalInfo.add(p2);
		
		Personal p3 = new Personal("Sadikul Haque","Mr. Haque","Mrs. Haque","24-06-1999",
				"Pabna","01521121979");
		listOfPersonalInfo.add(p3);
		
		
	}
		
	
	public void academicInfo() {
        
		initializeAcademicInfo();
    
        FileOutputStream fout = null;
        ObjectOutputStream object_out_for_serializable = null;
        try {
            fout = new FileOutputStream("Academic.txt");
            object_out_for_serializable = new ObjectOutputStream(fout);
            
            object_out_for_serializable.writeObject(listOfAcademicInfo);
            object_out_for_serializable.flush();
                    
        } catch (FileNotFoundException ex) {
            System.out.println("FileOutputStream in " + ex.toString());
        } catch (IOException ex) {
            System.out.println("ObjectOutputStream in " + ex.toString());
        } 
	}
	
	public void initializeAcademicInfo() {
		
		Academic a1 = new Academic("Dip Saha","1171101","1001","3.85");
		listOfAcademicInfo.add(a1);
		
		Academic a2 = new Academic("Redowan Mahmud","1171102","1002","3.94");
		listOfAcademicInfo.add(a2);
		
		Academic a3 = new Academic("Sadikul Haque","1171103","1003","3.88");
		listOfAcademicInfo.add(a3);
		
		
	}
	
	
	public void printAllInfo() {
		try {
            
			
			ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("Personal.txt"));
            
            ArrayList<Personal> tempListOfPersonalInfo = 
                    (ArrayList<Personal>) ois.readObject();
            
            for (Personal deserializePersonalInfo : tempListOfPersonalInfo){
            	
            	System.out.println(deserializePersonalInfo);
            
            }
            
           
            
        } catch (IOException ex) {
        	System.out.println("ObjectOutputStream in " + ex.toString());
        } catch (ClassNotFoundException ex) {
        	System.out.println("ClassNotFoundException in " + ex.toString());
        }
		
		try {
            
			
			ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("Academic.txt"));
            
            ArrayList<Academic> tempListOfAcademicInfo = 
                    (ArrayList<Academic>) ois.readObject();
            
            for (Academic deserializeAcademicInfo : tempListOfAcademicInfo){
                
            	System.out.println(deserializeAcademicInfo);
            
            }
           

        } catch (IOException ex) {
        	System.out.println("ObjectOutputStream in " + ex.toString());
        } catch (ClassNotFoundException ex) {
        	System.out.println("ClassNotFoundException in " + ex.toString());
        }
	}
	
	public static void main (String []args) {
		
		Student s =new Student ();
		s.addStudentInfo();
		s.printAllInfo();
	}
	
	
}
