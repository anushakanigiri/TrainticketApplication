package com.entity.demo;

public class UserSeat {
	private User user;
    private String seat;
    private double pricePaid;
	public UserSeat(User user, String seat, double pricePaid) {
		super();
		this.user = user;
		this.seat = seat;
		this.pricePaid = pricePaid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
    


	
		
	}


