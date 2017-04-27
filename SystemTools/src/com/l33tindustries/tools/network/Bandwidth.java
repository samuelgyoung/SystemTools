package com.l33tindustries.tools.network;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Bandwidth {
	
	final static Logger logger = Logger.getLogger(Bandwidth.class);
	
	/** This method does the calculations using WGET
     * 
     * @param theUrl The URL to retrieve
     * @exception IOException 
     */
	public void getBandwidth(String URL)
	{
		
		boolean DEBUG = false;
		
		long b = new java.util.Date().getTime();
		
		wget wg = new wget();
		
		try 
		{
			wg.get(URL,"file");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long a = new java.util.Date().getTime();
		
		File file = new File("file");
		
		// Get the number of bytes in the file
		long length = file.length();
		
		long bits = length * 8;
		
		if (DEBUG)
		{
			System.out.println("File Size in bytes: " + length );
			System.out.println("File Size in bits: " + bits );
		
			System.out.println("Milliseconds : " + (a-b));
			System.out.println("Seconds : " + ((a-b)/1000.0));
			System.out.println("Bits Per Second : " + bits/((a-b)/1000.0));
			System.out.println("KiloBits per Second: " +  (bits*0.0009765625)/((a-b)/1000.0));
			System.out.println("MegaBits Per Second : " + (bits* .000000953674)/((a-b)/1000.0));
		}
		
		System.out.println((bits* .000000953674)/((a-b)/1000.0));
		
		//Clean up the file
		file.delete();
	}

}
