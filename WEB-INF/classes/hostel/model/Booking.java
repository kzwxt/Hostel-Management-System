package hostel.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Booking implements Serializable{
	private static long serialVersionUID = 1L;
	private int bookid;
	private String reservedate;
	private int numberofpeople;
	private String roomavailability;
	private int customerid;
	private int roomid;
	private int employeeid;
	private boolean valid; // check if valid
	private Customer customer;
	private Employee employee;
	private Room room;
	
	private int totalBooking;
	private double totalProfit;
	private String mostbooked;
	private String mostReserved;

	


	public Booking() {
	}


	public int getBookid() {
		return bookid;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}


	public String getReservedate() {
		return reservedate;
	}


	public void setReservedate(String reservedate) {
		this.reservedate = reservedate;
	}


	public int getNumberofpeople() {
		return numberofpeople;
	}


	public void setNumberofpeople(int numberofpeople) {
		this.numberofpeople = numberofpeople;
	}


	public String getRoomavailability() {
		return roomavailability;
	}


	public void setRoomavailability(String roomavailability) {
		this.roomavailability = roomavailability;
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public int getRoomid() {
		return roomid;
	}


	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}


	public int getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	public boolean isValid() {
		return valid;
	}


	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getTotalBooking() {
		return totalBooking;
	}


	public void setTotalBooking(int totalBooking) {
		this.totalBooking = totalBooking;
	}
	public double getTotalProfit() {
		return totalProfit;
	}


	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}

	public String getMostbooked() {
		return mostbooked;
	}


	public void setMostbooked(String mostbooked) {
		this.mostbooked = mostbooked;
	}
	
	public String getMostReserved() {
		return mostReserved;
	}


	public void setMostReserved(String mostReserved) {
		this.mostReserved = mostReserved;
	}
	
}