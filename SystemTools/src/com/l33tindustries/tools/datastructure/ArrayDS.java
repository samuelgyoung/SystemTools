package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;

import com.l33tindustries.tools.file.SystemFile;

public class ArrayDS
{
	final static Logger logger = Logger.getLogger(ArrayDS.class);
	
	private int SearchCount = 0;
	
	int locn;
	
	/**
	 * @return the searchCount
	 */
	public int getSearchCount() {
		return this.SearchCount;
	}

	/**
	 * @param searchCount the searchCount to set
	 */
	public void setSearchCount(int searchCount) {
		this.SearchCount = searchCount;
	}

	private  Object[] Array;
	
	//DETERMINES CURRENT POSITION TO ADD DATA
	private int ArrayIndex;
	
	public ArrayDS()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		//NO SIZE PASSED IN, CREATES AN EMPTY ARRAY
		
		Array = new Object[0];
		ArrayIndex = 0;
		
		logger.trace(getCurrentMethodName() + " Exiting");
	}
	
	public ArrayDS(int ArraySize)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		//CREATE THE ARRAY OF THAT SIZE
		this.Array = new Object[ArraySize];
		ArrayIndex = 0;
		logger.trace(getCurrentMethodName() + " Exiting");
	}
	
	/*---------------------------------------------------------------------
    |  Method getArraySize()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Returns the size of the array in this class.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns: int - Size of the array
    *-------------------------------------------------------------------*/
	public int getArraySize()
	{
		logger.trace(getCurrentMethodName() + "Entering");
		logger.trace(getCurrentMethodName() + " Exiting");
		return this.Array.length;
	}
	
	/*---------------------------------------------------------------------
    |  Method clearArray
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean clearArray()
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		for (int i = 0; i < getArraySize(); i++)
		{
			Array[i] = null;	
		}
		ArrayIndex = 0;
		
		logger.trace(getCurrentMethodName() + " Exiting");
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method removeNullsFromArray
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean removeNullsFromArray()
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		int nullCounter = 0;
		
		for (int i = 0; i < getArraySize(); i++)
		{
			if (Array[i] == null)
			{
				nullCounter++;
			}
		}
		
		Object tempArray[] = new Object[getArraySize() - nullCounter];
		
		int j = 0;
		for (int i = 0; i < getArraySize(); i++)
		{		
			if (Array[i] == null)
			{
				
			}
			else
			{
				tempArray[j] = Array[i];
				j++;
			}
		}
		Array = tempArray;
		logger.trace(getCurrentMethodName() + " Exiting");
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method  deleteIndexValue
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean deleteIndexValue(int IndexOfData)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		if (IndexOfData >= Array.length) return false;
		
		Object tempArray[] = new Object[getArraySize() - 1];
		
		int aCount = 1;
		for (int i = 0; i < IndexOfData; i++)
		{
			tempArray[i] = Array[i];
			aCount++;
		}
		
		for (int i = aCount; i < Array.length; i++)
		{
			tempArray[i-1] = Array[i];
		}
		
		ArrayIndex--;
		Array = tempArray;
		logger.trace(getCurrentMethodName() + " Exiting : True");
		return true;
		
	}
	
	/*---------------------------------------------------------------------
    |  Method setIndexValueNull
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean setIndexValueNull(int IndexOfData)
	{	
		logger.trace(getCurrentMethodName() + "Entering ");
		if (IndexOfData > getArraySize())
		{
			logger.trace(getCurrentMethodName() + " Exiting : False");
			return false;
		}
		Array[IndexOfData] = null;
		logger.trace(getCurrentMethodName() + " Exiting : True");
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method isArrayEmpty
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean isArrayEmpty()
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		if (getArraySize() == 0) 
		{
			logger.trace(getCurrentMethodName() + " Exiting : True");
			return true;
		}
		else 
		{
			logger.trace(getCurrentMethodName() + " Exiting : False");
			return false; 
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method increaseArraySize
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	private boolean increaseArraySize(int size)
	{	
		logger.trace(getCurrentMethodName() + " Entering ");
		Object tempArray[] = new Object[getArraySize() + 1];
			
		for (int i = 0; i < getArraySize(); i++)
		{
			tempArray[i] = Array[i];
		}
		
		
		this.Array = tempArray;
		logger.debug(getCurrentMethodName() + " Creating increased size Array-" + this.Array.hashCode());
		logger.trace(getCurrentMethodName() + " Exiting : True");
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method printArray
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public void printArray()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if(Array.length == 0) System.out.println("Array-" +  Array.hashCode() + " is empty.");
		
		for (int i = 0; i < getArraySize(); i++)
		{
			System.out.println("Array-" + Array.hashCode() + " [" + i + "]" + " = " + Array[i]);
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method addToArray
    |
    |  Author: gyoung
    |  
    |  Purpose:  
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |     
    |  Returns:  
    | 		
    *-------------------------------------------------------------------*/
	public boolean addToArray(Object data)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		if (ArrayIndex >= Array.length) 
		{
			increaseArraySize(1);
		}
			
		Array[ArrayIndex] = data;
		ArrayIndex++;
				
		return true;	
	}
	
	/*---------------------------------------------------------------------
    |  Method seqSearchIndex
    |
    |  Author: gyoung
    |  
    |  Purpose:  Returns the first index that a value was found in an array.
    |
    |  Pre-condition: None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- The last index in the array you want to try looking for.
    |
    |  Returns:  
    | 		int - Value of index where target was found.
    |		-1 	- Value was not found.
    |		-2	- An error has happened.
    *-------------------------------------------------------------------*/
	public int seqSearchIndex(Object target, int last)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		
		setSearchCount(0);
		
		if (last > Array.length) 
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			last = Array.length;
		}
		
		int looker = 0;
		while(looker < last && Array[looker] != target)
		{
			//logger.debug(getCurrentMethodName() + " checking Array-" +  this.Array.hashCode() + "[" + looker + "]");
			setSearchCount(getSearchCount()+1);
			looker++;
		}
		
		if ( looker == Array.length) 
		{ 
			logger.trace(getCurrentMethodName() + " Exiting : -1");
			return -1;
		}
		else if ( target == Array[looker]) 
		{
			logger.trace(getCurrentMethodName() + " Exiting : " + looker);
			return looker;
		}
		else  
		{
			//ERROR
			logger.trace(getCurrentMethodName() + " Exiting : ERROR -2");
			return -2; 
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method seqSearch
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Searches for a value in an array. This can be used when
    |	the list is not ordered. It is generally for small lists that are
    |	not searched often. In other cases, it is more optimal to sort the
    |   list then search via a binary search.
    |
    |  Efficency: Linear or O(n)
    |
    |  Pre-condition:  None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- The last index in the array you want to try looking for.
    |				if last is 0, then it is assumed the entire array is to 
    |				be searched.
    |
    |  Returns:  
    |		- true -- Value was found
    |		- false -- Value was not found
    *-------------------------------------------------------------------*/
	public boolean seqSearch(Object target, int last)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		
		setSearchCount(0);
		
		//IF THE VALUE FOR LAST IS LARGER THAN THE ARRAY, SET IT TO THE LAST VALUE
		//TO AVOID AN OUT OF BOUNDS EXCEPTION
		if (last > Array.length)
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			last = Array.length;
		}
		
		//IF LAST = 0, ASSUME IT'S THE ENTIRE ARRAY
		if ( last == 0 ) 
		{
			last = Array.length;
		}
		
		//SET THE LOOKER TO 0, THE START OF THE ARRAY.
		int looker = 0;
		
		//WHILE THE VALUE IS NOT FOUND AND WE HAVE NOT REACHED THE END OF THE ARRAY
		while(looker < last && Array[looker] != target)
		{
			//logger.debug(getCurrentMethodName() + " checking Array-" +  this.Array.hashCode() + "[" + looker + "]");
			setSearchCount(getSearchCount()+1);
			looker++;
		}
		
		locn = looker;
		
		//VALUE WAS NOT FOUND, WE REACHED THE END OF THE ARRAY
		if ( looker == Array.length) 
		{ 
			logger.trace(getCurrentMethodName() + " Exiting : false");
			return false; 
		}
		
		//VALUE WAS FOUND.
		else if ( target == Array[looker]) 
		{
			logger.trace(getCurrentMethodName() + " Exiting : true");
			return true;
		}
		
		//ERROR
		else  
		{
			logger.trace(getCurrentMethodName() + " Exiting : false");
			return false; 
		}
	}

	/*---------------------------------------------------------------------
    |  Method sentinelSearch
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Variation on sequential search. It assumes that we know the
    |	target will be found in the array and eliminates the test at the end
    |	of the list.
    |
    |  Efficency: Linear or O(n)
    |
    |  Pre-condition:  None.
    |
    |  Post-condition: None.
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- The last index in the array you want to try looking for.
    |				if last is 0, then it is assumed the entire array is to 
    |				be searched.
    |
    |  Returns:  
    |		- true -- Value was found
    |		- false -- Value was not found
    *-------------------------------------------------------------------*/
	public boolean sentinelSearch(Object target, int last)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		
		if(last == getArraySize() || last == 0)
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			addToArray(target);
		}
		else
		{
			Array[last+1] = target;
		}
		
		//SET THE LOOKER TO 0, THE START OF THE ARRAY.
		int looker = 0;
				
		//WHILE THE VALUE IS NOT FOUND AND WE HAVE NOT REACHED THE END OF THE ARRAY
		while(Array[looker] != target)
		{
			looker++;
		}
		
		if ( looker <= last)
		{
			logger.trace(getCurrentMethodName() + " Exiting : true");
			locn = looker;
			return true;
		}
		else
		{
			logger.trace(getCurrentMethodName() + " Exiting : false");
			locn = last;
			return false;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method probabilitySearch
    |
    |  Author: sgyoung
    |  
    |  Purpose:  The array is ordered with the mose probable search elements
    |	at the begining of the array and the least probably at the end. It is 
    |	useful when relatively few elements are the targets for most of the
    |	searches. To ensure that the probability ording is correct over time,
    |	in each search we exchange the located element with the element immediately
    |	before it in the array.
    |
    |  Pre-condition:  	
    |					- last is the index to last element in the list
    |					- target contains the data to be located
    |
    |  Post-condition: 	- if found : matching index stored in locn & found true
    |						and element moved up in priority
    |					- if not found : last stored in locn & found false 
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- 	The last index in the array you want to try looking for.
    |				if last is 0, then it is assumed the entire array is to 
    |				be searched.
    |
    |  Returns:  
    |		- true 	-- Value was found
    |		- false	-- Value was not found
    *-------------------------------------------------------------------*/
	public boolean probabilitySearch(Object target, int last)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		
		boolean found = false;
		
		//IF THE VALUE FOR LAST IS LARGER THAN THE ARRAY, SET IT TO THE LAST VALUE
		//TO AVOID AN OUT OF BOUNDS EXCEPTION
		if ((last > Array.length) || (last == 0))
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			last = (Array.length-1);
		}
		
		setSearchCount(0);
		
		int looker = 0;
		
		//looker < last and traget not equal list[looker]
		while((looker < last) && (Array[looker] != target))
		{	
			setSearchCount(getSearchCount()+1);
			looker++;
		}
				
		if (target == Array[looker])
		{
			found = true;
			
			if (looker > 0)
			{
				Object temp = Array[looker-1];
				Array[looker-1] = Array[looker];
				Array[looker] = temp;
				looker = looker - 1;
			}
		}
		else
		{
			found = false;
		}
		
		locn = looker;
		
		return found;
		
	}
	
	/*---------------------------------------------------------------------
    |  Method orderedListSearch
    |
    |  Author: sgyoung
    |  
    |  Purpose:  We can stop when the target becomes less than or equal to 
    |	the current element we are testing. This incorporates the sentinel
    |	concept by bypassing the search loop when the target is greater than
    |	the last item. In other words, it eliminates the need to test for the
    |	end of the loop.
    |
    |  Efficency: Linear or O(n)
    |
    |  Pre-condition:  	- list must be ordered
    |					- last is the index to last element in the list
    |					- target contains the data to be located
    |					- locn is address of index in calling algorithm
    |
    |  Post-condition: 	- if found : matching index stored in locn
    |						& found true and element moved up in priority
    |					- if not found : last stored in locn
    |						& found false 
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- 	The last index in the array you want to try looking for.
    |				if last is 0, then it is assumed the entire array is to 
    |				be searched.
    |
    |  Returns:  
    |		- true 	-- Value was found
    |		- false	-- Value was not found
    *-------------------------------------------------------------------*/
	public <T extends Comparable<T>> boolean orderedListSearch(T target, int last)
	{
		logger.trace(getCurrentMethodName() + "Entering ");
		boolean found = false;
		
		//IF THE VALUE FOR LAST IS LARGER THAN THE ARRAY, SET IT TO THE LAST VALUE
		//TO AVOID AN OUT OF BOUNDS EXCEPTION
		if ((last > Array.length) || (last == 0))
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			last = (Array.length-1);
		}
		
		setSearchCount(0);
		
		int looker = 0;
		
		logger.debug("Ordered search list target : "  + target);
		
		logger.debug("Testing: " + target + " < " + (T) Array[last]);

		////7/20/16: if(target < Integer.valueOf((Integer) Array[last]))
		if(target.compareTo((T) Array[last]) < 0)
		{
			logger.debug("True : " + target + " < " + (T) Array[last]);

			////7/20/16: while(target > Integer.valueOf((Integer) Array[looker]))
			while(target.compareTo((T) Array[looker]) > 0)
			{
				logger.debug("Testing: " + target + " > " + (T) Array[looker]);
				setSearchCount(getSearchCount()+1);
				looker = looker +1;
			}
		}
		else
		{
			logger.debug("Got to the last value. : " + looker);
			looker = last;	
		}
		
		//7/20/16: if ( target == Integer.valueOf((Integer) Array[looker]))
		if ( target == (T) Array[looker])
		{
			logger.debug("Found the value : " + target);
			found = true;
		}
		else
		{
			logger.debug("Did not find value : " + target);
			found = false;
		}
		
		locn = looker;
		
		logger.trace(getCurrentMethodName() + " Exiting : " + found);
		return found;
	}
	
	/*---------------------------------------------------------------------
    |  Method binarySearch
    |
    |  Author: sgyoung
    |  
    |  Purpose:  
    |
    |  Efficency: Logarithmic or O(log2n) 
    |
    |  Pre-condition:  	- list must be ordered
    |					- last is the index to last element in the list
    |					- target contains the data to be located
    |					- locn is address of index in calling algorithm
    |
    |  Post-condition: 	- if found : matching index stored in locn
    |						& found true and element moved up in priority
    |					- if not found : last stored in locn
    |						& found false 
    |
    |  Parameters:
    |      target -- Object value that you are looking for.
    |	   last -- 	The last index in the array you want to try looking for.
    |				if last is 0, then it is assumed the entire array is to 
    |				be searched.
    |
    |  Returns:  
    |		- true 	-- Value was found
    |		- false	-- Value was not found
    *-------------------------------------------------------------------*/
	public <T extends Comparable<T>> boolean binarySearch(T target, int end)
	{
		setSearchCount(0);
		
		boolean found = false;
		
		int first = 0;
		int last = end;
		int mid = 0;
		
		if ((last > Array.length) || (last == 0))
		{
			logger.debug("last : " + last  + " > " + Array.length + " or " + " last is 0");
			last = (Array.length-1);
		}
		
		logger.debug("Testing - first : " + first  + " <= last : " + last);
		while (first <= last)
		{
			logger.debug("first : " + first  + " <= last : " + last);
			setSearchCount(getSearchCount()+1);
			mid = (first + last) / 2;
			logger.debug("mid: " + mid + " first: " + first + "last: " + last);
			//7/20/16: if (target.compareTo(Array[mid]) > Integer.valueOf((Integer) Array[mid]))
			if (target.compareTo((T) Array[mid]) > 0 )
			{
				logger.debug("Looking in upper half.");
				//Look in the upper half
				first = mid + 1;
			}
			//7/20/16: else if (target < Integer.valueOf((Integer) Array[mid]))
			else if (target.compareTo((T) Array[mid]) < 0)
			{
				logger.debug("Looking in lower half.");
				//Look in the lower half
				last = mid - 1;
			}
			else
			{
				logger.debug("Found the value : " + target);
				//Found equal: force exit
				first = last + 1;
			}
		}
		
		locn = mid;
		
		if (target == (T) Array[mid])
		{
			found = true;
		}
		else
		{
			found = false;
		}
			
		return found;
	}
	
	//Used for debug.
	private static String getCurrentMethodName() 
 	{ 
 		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace(); 
 		
 		return 	stackTraceElements[1].toString().replaceFirst(stackTraceElements[1].toString().split("\\.")[0]+"\\.", "");
 	}
}
