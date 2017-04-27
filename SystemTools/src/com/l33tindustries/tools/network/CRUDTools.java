/**
 * 
 */
package com.l33tindustries.tools.network;

import java.io.*;
import java.net.*;

import org.apache.log4j.Logger;

import com.l33tindustries.tools.file.*;

/**
 * @author samuelyoung
 *
 */
public class CRUDTools {

	final static Logger logger = Logger.getLogger(CRUDTools.class);
	static final String FS = File.separator;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SystemFile.createOrOverwriteAFile("aaba");
	}
	
	/** This method does a GET and writes the information to the file specified.
     * 
     * @param theUrl The URL to retrieve
     * @param filename the local file to save to
     * @exception IOException 
     */
    public void get(String theUrl, String filename) throws IOException
    {
    	logger.trace("Entering ");
        try {
        	
        	logger.debug("Connecting to : " + theUrl);
        	
            URL gotoUrl = new URL(theUrl);
            InputStreamReader isr = new InputStreamReader(gotoUrl.openStream());
            BufferedReader in = new BufferedReader(isr);

            StringBuffer sb = new StringBuffer();
            String inputLine;
            
            //NO LONGER NEEDED
            //boolean isFirst = true;
            
            //GRAB THE CONTENTS AT THE URL
            logger.debug("Grabbing the contents of : " + theUrl);
            while ((inputLine = in.readLine()) != null){
                sb.append(inputLine+"\r\n");
            }
            //WRITE IT LOCALLY TO THE FILE
            logger.debug("Writing the contents to file : " + theUrl);
            SystemFile f = new SystemFile(filename);
            f.createOrOverwriteFile(sb.toString());
            logger.trace("Exiting ");
        }
        catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
    }
    
	public static void POSTJSON(String URL, int NumberOfFeildsInDoc, int LengthOfLines)
	{
		try {

			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
			
			
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
