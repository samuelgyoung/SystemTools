package com.l33tindustries.tools.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class SystemFile {

	final static Logger logger = Logger.getLogger(SystemFile.class);
	
	private String Filename;

	/**
	 * @return the filename
	 */
	public String getFilename() {
		logger.trace("Entering ");
		logger.trace("Exiting ");
		return Filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		logger.trace("Entering ");
		Filename = filename;
		logger.trace("Exiting ");
	}

	public SystemFile(String filename)
	{
		logger.trace("Entering ");
		setFilename(filename);
		logger.trace("Exiting ");
	}

	/** Writes a String to a local file. It will overwrite a file if it already exists.
	 * 
	 * @param outfile The file to create or overwrite to.
	 * @param content The contents of the file
	 * @exception IOException 
	 */
	public void createOrOverwriteFile(String content) 
	{
		logger.trace("Entering ");

		FileOutputStream fileoutputstream;

		try {

			logger.debug("Creating or overwriting file : " + getFilename());

			fileoutputstream = new FileOutputStream(getFilename());
			DataOutputStream dataoutputstream = new DataOutputStream(fileoutputstream);

			logger.debug("Writing to file " + getFilename() + " : " + content);
			dataoutputstream.writeBytes(content);

			logger.debug("Closing file : " + getFilename());

			dataoutputstream.flush();
			dataoutputstream.close();

			logger.debug("Done with file : " + getFilename());

			logger.trace("Exiting : Success ");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.trace("Entering : Error - IOException");
			e.printStackTrace();
		}

	}

	/**
	 * Returns an arraylist of each line in the file of this class.
	 *
	 */
	public ArrayList GetLines()
	{
		logger.trace(" Entering");
		ArrayList al = new ArrayList();

		try{

			logger.debug("Creating a file input stream : " +  getFilename());
			FileInputStream fstream = new FileInputStream(getFilename());
			
			logger.debug("Getting the object of DataInputStream : " +  getFilename());
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				logger.debug("Adding : " +  strLine);
				al.add(strLine);
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		logger.trace("Exiting : " + al);
		return al;
	}

	public boolean DeleteFile()
	{
		logger.trace(" Entering");
		File file = new File(Filename);

		boolean success = file.delete();
		if (!success){
			logger.debug("Deletion failed : " + getFilename());
			logger.trace(" Exiting");
			return false;
			
		}else{
			return true;

		}
	}
	
	public String ReturnFirstLine()
	{
		logger.trace("Entering");
		try
		{
			FileInputStream	fis2=new FileInputStream(getFilename());
			DataInputStream   input = new DataInputStream (fis2);
			
			String inputString = input.readLine();
			input.close();
			
			logger.debug("Exiting: " + inputString);
			return inputString;
		}
		catch (IOException ioe)
		{
			logger.trace("Exiting");
			return "NOT_FOUND";
		}	
	}
	
	public boolean fileExists()
	{
		File f = new File(getFilename());
		
		
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		
		return false;
	}
	
	public String OutputAllLines()
	{
		
		String str = null;
		try
		{
			FileInputStream	fis2=new FileInputStream(getFilename());
			DataInputStream   input = new DataInputStream (fis2);
			
			for( String line; (line=input.readLine()) != null; str =  str + line + "\n" );
			
		input.close();
		fis2.close();
		
		return str;
		
		}
		catch(IOException ioe)
		{
			return null;
		}
	}
	
	public int countLines() throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(Filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
}
