package application;

import java.io.Serializable;

public class Academic implements Serializable{
	
	private String name,resNo,roll,cgpa;
	
	public Academic(String name,String resNo,String roll,String cgpa) {
		
		this.name=name;
		this.resNo=resNo;
		this.roll=roll;
		this.cgpa=cgpa;
		
	}

	public String getName() {
		return name;
	}

	public String getResNo() {
		return resNo;
	}

	public String getRoll() {
		return roll;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Academic [name=" + name + ", resNo=" + resNo + ", roll=" + roll + ", cgpa=" + cgpa + "]";
	}
	
	
	
	
}
