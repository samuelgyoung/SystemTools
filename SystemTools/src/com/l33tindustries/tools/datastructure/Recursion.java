package com.l33tindustries.tools.datastructure;


/*---------------------------------------------------------------------
|  Class Recursion 
|
|  Author: sgyoung
|  
|  Purpose:  Recursion examples and testing. Recursiomn is the repetative
|	process which an algorithm calls itself.
|
*-------------------------------------------------------------------*/

public class Recursion 
{
	public Recursion()
	{
		
		
	}
	
	/*---------------------------------------------------------------------
    |  Method iterativeFactorial(int n)
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Calculates the factorial of a number using a loop. Note,
    |	this does not use recursion.
    |
    |  Pre-condition:  n is the number to be raised factorially
    |
    |  Post-condition: n! is returned
    |
    |  Parameters: number you want to factorial. e.g., 5! pass in 5
    *-------------------------------------------------------------------*/
	public int iterativeFactorial(int n)
	{
		int i =1;
		int factN = 1;
		
		while (i <= n)
		{
			factN = factN * i;
			i = i + 1;
		}
		
		return factN;
	}
	
}
