package hostel.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	private int roomid;
	private int room_size;
	private String room_details;
	private double room_price;
	private String room_type;
	private String room_status;
	 private int totalRooms;
	    private int availableRooms;
	    private int unavailableRooms;
	    private int bookedRooms;

	
	public Room() {
	}


	public int getRoomid() {
		return roomid;
	}


	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}


	public int getRoom_size() {
		return room_size;
	}


	public void setRoom_size(int room_size) {
		this.room_size = room_size;
	}


	public String getRoom_details() {
		return room_details;
	}


	public void setRoom_details(String room_details) {
		this.room_details = room_details;
	}


	public double getRoom_price() {
		return room_price;
	}


	public void setRoom_price(double room_price) {
		this.room_price = room_price;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}


	public String getRoom_status() {
		return room_status;
	}


	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}
	 public int getTotalRooms() {
	        return totalRooms;
	    }

	    public void setTotalRooms(int totalRooms) {
	        this.totalRooms = totalRooms;
	    }

	    public int getAvailableRooms() {
	        return availableRooms;
	    }

	    public void setAvailableRooms(int availableRooms) {
	        this.availableRooms = availableRooms;
	    }

	    public int getUnavailableRooms() {
	        return unavailableRooms;
	    }

	    public void setUnavailableRooms(int unavailableRooms) {
	        this.unavailableRooms = unavailableRooms;
	    }

	    public int getBookedRooms() {
	        return bookedRooms;
	    }

	    public void setBookedRooms(int bookedRooms) {
	        this.bookedRooms = bookedRooms;
	    }
}