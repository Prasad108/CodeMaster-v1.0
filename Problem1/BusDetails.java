package com.awl.codemaster.technomaster;

public class BusDetails {
    int noOfDays;
    String teaBreakTime;
    Bus bus;
    
    public BusDetails() {}
	public BusDetails(int noOfDays, String teaBreakTime, Bus bus) {
		super();
		this.noOfDays = noOfDays;
		this.teaBreakTime = teaBreakTime;
		this.bus = bus;
	}
	
	
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getTeaBreakTime() {
		return teaBreakTime;
	}
	public void setTeaBreakTime(String teaBreakTime) {
		this.teaBreakTime = teaBreakTime;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
    
}
