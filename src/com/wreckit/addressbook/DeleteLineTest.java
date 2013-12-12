package com.wreckit.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
 
public class DeleteLineTest 
{
 
  public static void main(String[] args) throws IOException 
  {
 
	DeleteLineTest sniper = new DeleteLineTest();
	sniper.run();
 
  }
 
  public void run() throws IOException 
  {
	File inputFile = new File("D:\\KureidoDevtools\\eclipse\\workspace\\starlight_addressbook\\src\\com\\wreckit\\addressbook\\donotedit.csv");
	File tempFile = new File("D:\\KureidoDevtools\\eclipse\\workspace\\starlight_addressbook\\src\\com\\wreckit\\addressbook\\SniperCSV.csv");
	BufferedReader br = new BufferedReader(new FileReader(inputFile));
	String line;
//	String cvsSplitBy = ",";
	BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
 
	try 
	{
 
		while((line = br.readLine()) != null)
	    {
	        //trim newline when comparing with lineToRemove
	        String trimmedLine = line.trim();
	        if(!trimmedLine.startsWith("Mirinda")) 
	        {
	         writer.write(line + "\n"); 
	        }
	    }   
	    writer.close();
	    br.close();
	    
	    if(!inputFile.delete())
	    {
	        JOptionPane.showMessageDialog(null, "Could not rename file");
	        return;
	    }
	    if(!tempFile.renameTo(inputFile))
	        JOptionPane.showMessageDialog(null, "Could not rename file");

 
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