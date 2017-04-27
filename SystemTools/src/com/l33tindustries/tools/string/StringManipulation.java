package com.l33tindustries.tools.string;

import org.apache.log4j.Logger;

public class StringManipulation 
{
	final static Logger logger = Logger.getLogger(StringManipulation.class);
	
	public String sReplaceAllCharactersInAString(String[] replaceCharacters, String sReplaceString , char c)
	{		
		for (int i = 0; i < replaceCharacters.length; i++ )
		{			
			sReplaceString = sReplaceString.replace(replaceCharacters[i].charAt(0), c);
		}
		
		return sReplaceString;
	}
}
