package hostel.model;

import java.io.Serializable;

/**
 * Author: FES
 */
public class MainDashboard implements Serializable {
    private static final long serialVersionUID = 1L;
    private int totalRooms;
    private int totalCustomers;
    private int availableRooms;
    private int unavailableRooms;
    private int bookedRooms;
    private int totalEmployee;
    private int totalBooking;

    private int januaryCount;
    private int februaryCount;
    private int marchCount;
    private int aprilCount;
    private int mayCount;
    private int juneCount;
    private int julyCount;
    private int augustCount;
    private int septemberCount;
    private int octoberCount;
    private int novemberCount;
    private int decemberCount;
    
    private double profitq1;
    private double profitq2;
    private double profitq3;
    private double profitq4;
    
    
    
	public MainDashboard() {
    }
	public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
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

    public int getJanuaryCount() {
        return januaryCount;
    }

    public void setJanuaryCount(int januaryCount) {
        this.januaryCount = januaryCount;
    }

    public int getFebruaryCount() {
        return februaryCount;
    }

    public void setFebruaryCount(int februaryCount) {
        this.februaryCount = februaryCount;
    }

    public int getMarchCount() {
        return marchCount;
    }

    public void setMarchCount(int marchCount) {
        this.marchCount = marchCount;
    }

    public int getAprilCount() {
        return aprilCount;
    }

    public void setAprilCount(int aprilCount) {
        this.aprilCount = aprilCount;
    }

    public int getMayCount() {
        return mayCount;
    }

    public void setMayCount(int mayCount) {
        this.mayCount = mayCount;
    }

    public int getJuneCount() {
        return juneCount;
    }

    public void setJuneCount(int juneCount) {
        this.juneCount = juneCount;
    }

    public int getJulyCount() {
        return julyCount;
    }

    public void setJulyCount(int julyCount) {
        this.julyCount = julyCount;
    }

    public int getAugustCount() {
        return augustCount;
    }

    public void setAugustCount(int augustCount) {
        this.augustCount = augustCount;
    }

    public int getSeptemberCount() {
        return septemberCount;
    }

    public void setSeptemberCount(int septemberCount) {
        this.septemberCount = septemberCount;
    }

    public int getOctoberCount() {
        return octoberCount;
    }

    public void setOctoberCount(int octoberCount) {
        this.octoberCount = octoberCount;
    }

    public int getNovemberCount() {
        return novemberCount;
    }

    public void setNovemberCount(int novemberCount) {
        this.novemberCount = novemberCount;
    }

    public int getDecemberCount() {
        return decemberCount;
    }

    public void setDecemberCount(int decemberCount) {
        this.decemberCount = decemberCount;
    }
    public int getTotalEmployee() {
		return totalEmployee;
	}

	public void setTotalEmployee(int totalEmployee) {
		this.totalEmployee = totalEmployee;
	}

	public int getTotalBooking() {
		return totalBooking;
	}

	public void setTotalBooking(int totalBooking) {
		this.totalBooking = totalBooking;
	}
	
	public double getProfitq1() {
		return profitq1;
	}
	public void setProfitq1(double profitq1) {
		this.profitq1 = profitq1;
	}
	public double getProfitq2() {
		return profitq2;
	}
	public void setProfitq2(double profitq2) {
		this.profitq2 = profitq2;
	}
	public double getProfitq3() {
		return profitq3;
	}
	public void setProfitq3(double profitq3) {
		this.profitq3 = profitq3;
	}
	public double getProfitq4() {
		return profitq4;
	}
	public void setProfitq4(double profitq4) {
		this.profitq4 = profitq4;
	}
	
}
