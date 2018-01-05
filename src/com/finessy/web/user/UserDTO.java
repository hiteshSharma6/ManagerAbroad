package com.finessy.web.user;

public class UserDTO {
	
	private int studentId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String emailHash;
	private String status;
	
	
	public UserDTO(String firstName, String lastName, String emailId, String password, String emailHash, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.emailHash = emailHash;
		this.status = status;
	}
			
	public UserDTO(int studentId, String firstName, String lastName) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		}

	public UserDTO(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
		
	@Override
	public String toString() {
		return "UserDTO [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", password=" + password + ", emailHash=" + emailHash + ", status=" + status + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailHash() {
		return emailHash;
	}

	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStudentId() {
		return studentId;
	}
		
}
