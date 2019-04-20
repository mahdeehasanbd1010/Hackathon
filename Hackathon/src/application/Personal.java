package application;

import java.io.Serializable;

public class Personal implements Serializable{
	
	private String name,fathersName,mothersName,dateOfBirth,address,phoneNumber;
	
	public Personal(String name,String fathersName,String mothersName,String dateOfBirth,String address
			,String phoneNumber) {
		
		this.name=name;
		this.fathersName=fathersName;
		this.mothersName=mothersName;
		this.dateOfBirth=dateOfBirth;
		this.address=address;
		this.phoneNumber=phoneNumber;
		
	}

	public String getName() {
		return name;
	}

	public String getFathersName() {
		return fathersName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	@Override
	public String toString() {
		return "Personal [name=" + name + ", fathersName=" + fathersName + ", mothersName=" + mothersName
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}	
	
	
	
}
