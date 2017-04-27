package com.l33tindustries.tools.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class wget {

	   static final String FS = File.separator;

	    /** This method does the actual GET
	     * 
	     * @param theUrl The URL to retrieve
	     * @param filename the local file to save to
	     * @exception IOException 
	     */
	    public void get(String theUrl, String filename) throws IOException
	    {
	        try {
	            URL gotoUrl = new URL(theUrl);
	            InputStreamReader isr = new InputStreamReader(gotoUrl.openStream());
	            BufferedReader in = new BufferedReader(isr);

	            StringBuffer sb = new StringBuffer();
	            String inputLine;
	            //boolean isFirst = true;
	            
	            //grab the contents at the URL
	            while ((inputLine = in.readLine()) != null){
	                sb.append(inputLine+"\r\n");
	            }
	            //write it locally
	            createAFile(filename, sb.toString());
	        }
	        catch (MalformedURLException mue) {
	            mue.printStackTrace();
	        }
	        catch (FileNotFoundException e)
	        {
	        	createAFile(filename, "N/A");
	        }
	        catch (IOException ioe) {
	            throw ioe;
	        }
	    }

	    //creates a local file
	    /** Writes a String to a local file
	     * 
	     * @param outfile the file to write to
	     * @param content the contents of the file
	     * @exception IOException 
	     */
	    public static void createAFile(String outfile, String content) throws IOException {
	        FileOutputStream fileoutputstream = new FileOutputStream(outfile);
	        DataOutputStream dataoutputstream = new DataOutputStream(fileoutputstream);
	        dataoutputstream.writeBytes(content);
	        dataoutputstream.flush();
	        dataoutputstream.close();
	    }
	
}
