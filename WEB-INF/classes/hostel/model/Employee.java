package hostel.model;

import java.io.Serializable;

public class Employee{
	private int employeeid;
	private String employee_name;
	private String employee_email;
	private String employee_username;
	private String employee_password;
	private String employee_ic;
	private String employee_position;
	private String employee_phone;
	private String employee_address;
	private int employee_bankid;
	
	private boolean valid;
	
	
	public Employee() {
	}


	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getEmployee_email() {
		return employee_email;
	}


	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}


	public String getEmployee_username() {
		return employee_username;
	}


	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}


	public String getEmployee_password() {
		return employee_password;
	}


	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}


	public boolean isValid() {
		return valid;
	}


	public void setValid(boolean valid) {
		this.valid = valid;
	}


	public String getEmployee_ic() {
		return employee_ic;
	}


	public void setEmployee_ic(String employee_ic) {
		this.employee_ic = employee_ic;
	}


	public String getEmployee_position() {
		return employee_position;
	}


	public void setEmployee_position(String employee_position) {
		this.employee_position = employee_position;
	}


	public String getEmployee_phone() {
		return employee_phone;
	}


	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}


	public String getEmployee_address() {
		return employee_address;
	}


	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}


	public int getEmployee_bankid() {
		return employee_bankid;
	}


	public void setEmployee_bankid(int employee_bankid) {
		this.employee_bankid = employee_bankid;
	}
	
	
	
	
	
	
	
	
	


	
	
	
}