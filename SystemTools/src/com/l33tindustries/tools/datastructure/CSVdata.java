package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class CSVdata 
{
	private static Logger logger = Logger.getLogger(CSVdata.class.getName());
	
	private String CSVheader;
	/**
	 * @return the cSVheader
	 */
	public String getCSVheader() {
		return CSVheader;
	}

	/**
	 * @param cSVheader the cSVheader to set
	 */
	public void setCSVheader(String cSVheader) {
		CSVheader = cSVheader;
	}

	/**
	 * @return the cSVString
	 */
	public String getCSVString() {
		return this.CSVString;
	}

	/**
	 * @param cSVString the cSVString to set
	 */
	public void setCSVString(String cSVString) {
		CSVString = cSVString;
	}

	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return this.delimiter;
	}

	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	private String CSVString;
	
	private String delimiter;
	
	private JsonObject JSONdoc;
	
	public CSVdata()
	{
		
	}
	
	public CSVdata(String csvHeader, String csvString)
	{
		JSONdoc = new JsonObject();
		this.CSVheader =  csvHeader;
		this.CSVString = csvString;
		this.delimiter = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
	}
	
	public CSVdata(String csvHeader, String csvString, String Delimiter)
	{
		JSONdoc = new JsonObject();
		this.CSVheader = csvHeader;
		this.CSVString = csvString;
		this.delimiter = Delimiter;
	}
	
	private static String getCurrentMethodName() 
 	{ 
 		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace(); 
 		
 		return 	stackTraceElements[1].toString().replaceFirst(stackTraceElements[1].toString().split("\\.")[0]+"\\.", "");
 	}
	
	public JsonObject CSVLinetoJSON()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		logger.debug(getCurrentMethodName() + " Processing Line: " + CSVString);
		
		String[] CSVheaderTokens = getCSVheader().split(delimiter, -1);
		String[] CSVStringTokens = getCSVString().split(delimiter, -1);
		
		int LineCSVCount = 0;
		for(String t : CSVheaderTokens) {
            
            logger.trace(getCurrentMethodName() +" Adding Element Index: " + LineCSVCount + " name: " + t + ", element: " + CSVStringTokens[LineCSVCount]);

            if((CSVStringTokens[LineCSVCount].startsWith("\"") && CSVStringTokens[LineCSVCount].endsWith("\"")) || (CSVStringTokens[LineCSVCount].startsWith("'") && CSVStringTokens[LineCSVCount].endsWith("'")))
            {
            	logger.trace(getCurrentMethodName() +" Token is a String");
            	try
            	{
            		CSVStringTokens[LineCSVCount] = CSVStringTokens[LineCSVCount].replaceAll("\"", "");
            		JSONdoc.add(t, new JsonPrimitive(CSVStringTokens[LineCSVCount]));
            	}
            	catch (NumberFormatException e)
        		{
            		logger.info(getCurrentMethodName() +" Error adding :" + CSVStringTokens[LineCSVCount]);
        		}
            	
            }
            else
            {
            	logger.trace(getCurrentMethodName() +" Token does not contain quotes : " + CSVStringTokens[LineCSVCount]);
            	
            	if(CSVStringTokens[LineCSVCount].contains("."))
            	{
            		logger.trace(getCurrentMethodName() +" Token is a floating number.. casting");
            		
            		try
            	    {
            			logger.trace(getCurrentMethodName() +" Trying to cast :" + CSVStringTokens[LineCSVCount]);
            			float data = Float.parseFloat(CSVStringTokens[LineCSVCount]);
            			logger.trace(getCurrentMethodName() +" Success!");
            			JSONdoc.add(t, new JsonPrimitive(data));
            	    }
            		catch (NumberFormatException e)
            		{
            			logger.trace(getCurrentMethodName() +" Failed to cast. Must be a string: " + CSVStringTokens[LineCSVCount]);
            			JSONdoc.add(t, new JsonPrimitive(CSVStringTokens[LineCSVCount]));
            		}
            	}
            	else
            	{
            		try
            	    {
            			logger.trace(getCurrentMethodName() +" Token is an integer number.. tring to cast: " + CSVStringTokens[LineCSVCount]);
            			int data = Integer.parseInt(CSVStringTokens[LineCSVCount]);
            			logger.trace(getCurrentMethodName() +" Success!");
                		JSONdoc.add(t, new JsonPrimitive(data));
            	    }
            		catch (NumberFormatException e)
            		{
            			logger.trace(getCurrentMethodName() +" Can't cast number. Must be a string: " + CSVStringTokens[LineCSVCount]);
            			JSONdoc.add(t, new JsonPrimitive(CSVStringTokens[LineCSVCount]));
            		}
            	}
            	
            	
            }
            	            
            LineCSVCount++;
        }
		logger.trace(getCurrentMethodName() + " Exiting: " + JSONdoc);
		return JSONdoc;
	}
	
	public static void main(String[] args) 
	{
		logger.trace(getCurrentMethodName() + " Entering application.");
		//CSVdata t = new CSVdata();
		//t.runTest();
		logger.trace(getCurrentMethodName() + " Exiting application.");
	}
	
	public void runTest()
	{
		String testcsv =  "\"\\a\",'b',1,\"2.0\",2.1";

		//System.out.println(CSVLinetoJSON("test1,test2,test3,test4,test5",testcsv));
		//System.out.println(CSVLinetoJSON("test4,test5,test6", "a,b,c"));
		
	}
}
