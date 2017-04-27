package com.l33tindustries.tools.string;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class StringInfo 
{
	final static Logger logger = Logger.getLogger(StringInfo.class);

	/** Writes a String to a local file. It will overwrite a file if it already exists.
	 * 
	 * @param string String to analyze.
	 * @param characterToCount Character to count in the string.
	 */
	public int getNumberOfCharacters(String string, char characterToCount)
	{	
		logger.trace("Entering ");

		int NumberOfCharacters = 0;

		for (int i = 0; i < string.length(); i++ )
		{
			if (string.charAt(i) == characterToCount)
			{
				logger.debug("Found a character. Total found:  " + NumberOfCharacters);
				NumberOfCharacters++;
			}			
			else
			{
				//DO NOTHING
			}
		}

		logger.trace("Exiting : " + NumberOfCharacters);
		return NumberOfCharacters;
	}
	
	public int iNumberOfAllCharactersInLine(String sTestString, char c)
	{	
		int iNumberOfCharacters = 0;
		
		for (int i = 0; i < sTestString.length(); i++ )
		{
			if (sTestString.charAt(i) == c)
			{
				iNumberOfCharacters++;
			}			
			else
			{
				//DO NOTHING
			}
		}
		
		return iNumberOfCharacters;
	}
	
	public ArrayList<String> ReturnStringsThatStartWithNumbers(String str)
	{
		ArrayList<String> al = new ArrayList<String>(); 
		
		String temp[] = str.split("\n");
		
		for(int i = 0; i < temp.length; i++)
		{
			if(Character.isDigit(temp[i].charAt(0)))
			{				
				al.add(temp[i]);
			}
		}
		
		return al;
	}

}
