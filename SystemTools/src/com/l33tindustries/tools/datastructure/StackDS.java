package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;



public class StackDS 
{
	
	/*
	 * NOTES: A stack is LIFO, all insertions and deletions happen at the top.
	 * - Good for reversing data
	 * - Used for the 8 Queens Problem.
	 */
	
	final static Logger logger = Logger.getLogger(LinkedListDS.class);
	

	
	/*---------------------------------------------------------------------
    |  Method StackDS()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Initializes metadata for Stack.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	public StackDS()
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		logger.trace(getCurrentMethodName() + " Exiting ");
	}
	
	/*---------------------------------------------------------------------
    |  Method createStack()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Initalizes metadata for the Stack
    |
    |  Pre-condition:  stack is structure for the metadata
    |
    |  Post-condition: metadata initialized
    |
    |  Parameters: None
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	public Stack createStack()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		Stack _stack = new Stack();
		
		logger.trace(getCurrentMethodName() + " Exiting : true");
		
		return _stack;
	} 
	
	/*---------------------------------------------------------------------
    |  Method pushStack()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Insert (push) one item into the stack.
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					data contain data to be pushed into stack
    |
    |  Post-condition: data have been pushed into the stack
    |
    |  Parameters: data, stack reference
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	public boolean pushStack(Object dataIn, Stack stack)
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		//TODO: Check if the stack is full
		//if (stack full)
			//success = false;
		
		logger.debug(getCurrentMethodName() + " Creating new pointer for top of stack.");
		Node newPtr = new Node();
		
		logger.debug(getCurrentMethodName() + " Setting the data for the new pointer.");
		newPtr.setData(dataIn);
		logger.debug(getCurrentMethodName() + " Getting the current top of the stack and setting it below the new node in the stack.");
		newPtr.setNext(stack.getTop());
		
		logger.debug(getCurrentMethodName() + " Setting the new node as the top of the stack");
		stack.setTop(newPtr);
		
		logger.debug(getCurrentMethodName() + " Increasing the stack count.");
		stack.setCount(stack.getCount() + 1);
		
		logger.trace(getCurrentMethodName() + " Exiting ");
		
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method popStack()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Pops the item on the top of the stack.
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					   |
    |  Post-condition: data have been pushed into the stack
    |
    |  Parameters: stack reference
    |
    |  Returns: True if successful, false if underflow
    *-------------------------------------------------------------------*/
	public boolean popStack(Stack stack)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		boolean success;
		
		if(stackEmpty(stack) == true)
		{
			logger.debug(getCurrentMethodName() + " Stack is empty, nothing to pop.");
			success = false;
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Setting the top of the stack to the node below the current top.");
			stack.setTop(stack.getTop().next);
			
			logger.debug(getCurrentMethodName() + " Decreasing the stack count.");
			stack.setCount(stack.getCount() - 1);
			
			success = true;
		}
		
		logger.trace(getCurrentMethodName() + " Exiting ");
		return success;
	}

	/*---------------------------------------------------------------------
    |  Method stackTop()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Retrieves the data from the top of the stack without changing it.
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					   |
    |  Post-condition: data have been returned to calling algorithm
    |
    |  Parameters: stack reference
    |
    |  Returns: Stack Data
    *-------------------------------------------------------------------*/
	public Object stackTop(Stack stack)
	{
		if(stackEmpty(stack) == true)
		{
			logger.debug(getCurrentMethodName() + " Stack is empty.");
			return stack.getTop().data;
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Returning data from the stack.");
			return stack.getTop().data;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method stackEmpty()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Determines if the stack is empty and returns a boolean.
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					   |
    |  Post-condition: returns stack status
    |
    |  Parameters: stack reference
    |
    |  Returns: Boolean, true: stack is empty, false: stack contains data
    *-------------------------------------------------------------------*/
	private boolean stackEmpty(Stack stack)
	{
		if (stack.getCount() == 0)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
			
	}
	
	/*---------------------------------------------------------------------
    |  Method reverseStack()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Reverses a stack. 
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					   
    |  Post-condition: returns a new reversed stack
    |
    |  Parameters: stack reference
    |
    |  Returns: Reversed new stack
    *-------------------------------------------------------------------*/
	public Stack reverseStack(Stack stack)
	{
		Stack reversedStack = new Stack();
		
		Node t = stack.getTop();
		
		if(stackEmpty(stack) == true)
		{
			System.out.print("Stack is empty.");
		}
		
		else
		{
			while (t != null )
			{
				pushStack(t.getData(), reversedStack); 
				 
				t = t.getNext();
			}
		}
		
		return reversedStack;
	}
	
	public void printStack(Stack stack)
	{
		Node t = stack.getTop();
		
		if(stackEmpty(stack) == true)
		{
			System.out.print("Stack is empty.");
		}

		else
		{
			while (t != null )
			{
				System.out.print("[" + t.getData() + "] " + t.hashCode() + "\n");

				t = t.getNext();
			}
		}
		
	}
	
	/*---------------------------------------------------------------------
    |  Method stackCount()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Returns the number of elements in the stack.
    |
    |  Pre-condition:  Stack is metadata structure to a valid stack
    |					   
    |  Post-condition: returns stack count
    |
    |  Parameters: stack reference
    |
    |  Returns: Integer count of the number of elements in the stack
    *-------------------------------------------------------------------*/
	public int stackCount(Stack stack)
	{
		
		
		return stack.getCount();
	}
	
	//TODO:Determine how to test memory levels
	private boolean stackFull(Stack stack)
	{
		return false;
	}
	
	public class Stack
	{
		private int count;
		private Node top;
		
		Stack()
		{
			logger.debug(getCurrentMethodName() + " Setting head to null.");
			setTop(null);
			
			logger.debug(getCurrentMethodName() + " Setting count to 0.");
			this.setCount(0);
		}

		private int getCount() {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return count;
		}

		private void setCount(int count) {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			this.count = count;
		}

		private Node getTop() {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return top;
		}

		private void setTop(Node top) {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			this.top = top;
		}
		
		
	}
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		private Node next;
		// data carried by this node.
		// could be of any type you need.
		private Object data;
		
		// Node constructor
		public Node()
		{
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		public Node getNext() {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return next;
		}

		public void setNext(Node next) {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			this.next = next;
		}

		public Object getData() {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return data;
		}

		public void setData(Object data) {
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			this.data = data;
		}
	}
	
	
	/*---------------------------------------------------------------------
    |  Method getCurrentMethodName()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Gets the method name for debugging
    |
    |  Pre-condition:  None.
    |
    |  Post-condition: None.
    |
    |  Returns: Method Name.
    *-------------------------------------------------------------------*/
	private static String getCurrentMethodName() 
 	{ 
 		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace(); 
 		
 		return 	stackTraceElements[1].toString().replaceFirst(stackTraceElements[1].toString().split("\\.")[0]+"\\.", "");
 	}
}
