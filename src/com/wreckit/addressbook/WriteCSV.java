package com.wreckit.addressbook;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV 
{
	public static void addNewContact(Person p) throws IOException
	{
        FileWriter pw = new FileWriter("D:\\KureidoDevtools\\eclipse\\workspace\\starlight_addressbook\\src\\com\\wreckit\\addressbook\\SniperCSV.csv",true);
        pw.append(p.getLastName()); // Last Name
        pw.append(",");
        pw.append(p.getFirstName()); // First Name
        pw.append(",");
        pw.append(p.getAddress()); // Address
        pw.append(",");
        pw.append(p.getCity()); // City
        pw.append(",");
        pw.append(p.getState()); // State
        pw.append(",");
        pw.append(p.getZip()); // Zip
        pw.append(",");
        pw.append(p.getPhone()); // Phonenumber
        pw.append("\n");
        pw.flush();
        pw.close();
    }
	
	public static void main(String[] args) throws IOException
	{
		Person p = new Person("von Karma", "Axle", "PostgreSubdivision", "Berlin", "East Germany", "38742", "6592369562");
		addNewContact(p);
	}
}
