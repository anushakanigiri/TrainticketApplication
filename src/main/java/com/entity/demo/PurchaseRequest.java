package com.entity.demo;

public class PurchaseRequest {
	private User user;
    private String section;
    private double pricePaid;
	public PurchaseRequest(User user, String section, double pricePaid) {
		super();
		this.user = user;
		this.section = section;
		this.pricePaid = pricePaid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
    


	
	}


