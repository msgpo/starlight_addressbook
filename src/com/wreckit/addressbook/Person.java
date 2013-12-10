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
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	
	public String getPhone()
	{
		return phoneNumber;
	}
	
	public void setPhone(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String toString()
	{
		return lastName + "," + firstName + "," + address + "," + city + "," + state + "," + zip + "," + phoneNumber;
	}
}
