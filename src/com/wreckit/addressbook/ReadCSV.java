package com.wreckit.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class ReadCSV {
 
  public static void main(String[] args) {
 
	ReadCSV obj = new ReadCSV();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "D:\\KureidoDevtools\\eclipse\\workspace\\starlight_addressbook\\src\\com\\wreckit\\addressbook\\donotedit.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
 
	try 
	{
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
		{
 
		        // use comma as separator
			String[] person = line.split(cvsSplitBy);
			Person p = new Person(person[0], person[1], person[2], person[3], person[4], person[5], person[6]);
			System.out.println(p.getFirstName() + " " + p.getLastName() + " from " + p.getAddress() + ", " + p.getCity() + ", " + p.getState());
 
		}
 
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	} 
	finally 
	{
		if (br != null) 
		{
			try 
			{
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("Done");
  }
 
}