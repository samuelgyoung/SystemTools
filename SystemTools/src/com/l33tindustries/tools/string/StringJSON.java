package com.l33tindustries.tools.string;

public class StringJSON {

	public static String generateJSON(int NumberOfFields, int fieldlength)
	{
		String JSON = "{";

		for (int i = 1; i < NumberOfFields; i++)
		{

			JSON = JSON + "\"Feild" + i + "\": " + "\"" +  StringRandom.generateRandomString(fieldlength) + "\",";
		}

		JSON = JSON + "\"Feild0" + "\": " + "\"" +  StringRandom.generateRandomString(fieldlength) + "\"";
		
		JSON = JSON + "}";

		return JSON;

	}

}
