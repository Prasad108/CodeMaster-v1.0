package com.awl.codemaster.technomaster;

public class Bus {
    String busDirection;
    String busDepartureTime;
    String busArrivalTime;
    
    public Bus() {
    	
    }
    
	public Bus(String busDirection, String busDepartureTime, String busArrivalTime) {
		super();
		this.busDirection = busDirection;
		this.busDepartureTime = busDepartureTime;
		this.busArrivalTime = busArrivalTime;
	}
	
	public String getBusDirection() {
		return busDirection;
	}
	public void setBusDirection(String busDirection) {
		this.busDirection = busDirection;
	}
	public String getBusDepartureTime() {
		return busDepartureTime;
	}
	public void setBusDepartureTime(String busDepartureTime) {
		this.busDepartureTime = busDepartureTime;
	}
	public String getBusArrivalTime() {
		return busArrivalTime;
	}
	public void setBusArrivalTime(String busArrivalTime) {
		this.busArrivalTime = busArrivalTime;
	}
    
    
}
