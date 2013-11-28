package com.wreckit.addressbook;

public class Person 
{
	private String lastName;
	private String firstName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	
	public Person(String lastName, String firstName, String address, String city, String state, String zip, String phoneNumber)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
}
