package hostel.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private int customerid;
	private String customer_name;
	private String customer_phone;
	private String customer_ic;
	private String customer_email;
	private String customer_address;
	
	private int totalCustomers;
	private int completedReservations;
	private int upcomingReservations;
	private String newestCustomer;
	
	


	

	public Customer() {
	}


	public int getCustomerid() {
		return customerid;
	}


	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getCustomer_phone() {
		return customer_phone;
	}


	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}


	public String getCustomer_ic() {
		return customer_ic;
	}


	public void setCustomer_ic(String customer_ic) {
		this.customer_ic = customer_ic;
	}


	public String getCustomer_email() {
		return customer_email;
	}


	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}


	public String getCustomer_address() {
		return customer_address;
	}


	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
	 public int getTotalCustomers() {
	        return totalCustomers;
	    }

	    public void setTotalCustomers(int totalCustomers) {
	        this.totalCustomers = totalCustomers;
	    }
	    
	    public int getCompletedReservations() {
			return completedReservations;
		}


		public void setCompletedReservations(int completedReservations) {
			this.completedReservations = completedReservations;
		}


		public int getUpcomingReservations() {
			return upcomingReservations;
		}


		public void setUpcomingReservations(int upcomingReservations) {
			this.upcomingReservations = upcomingReservations;
		}
		
		public String getNewestCustomer() {
			return newestCustomer;
		}


		public void setNewestCustomer(String newestCustomer) {
			this.newestCustomer = newestCustomer;
		}

}