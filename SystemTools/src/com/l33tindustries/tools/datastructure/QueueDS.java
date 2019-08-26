package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;

public class QueueDS 
{
	/*---------------------------------------------------------------------
	/* Queue Notes: 
	 * - Inserted at the rear and deleted at the front
	 * - This makes queues FIFO
	 * - Inserting is known as enquque
	 * - Deleting is dequeuing
	 * - Queue Front returns the data from the front of the queue
	 * - If therre is no data in the queue, it's in a queue underflow state
	 * - The queue head requires two pointers and a counter
	 ---------------------------------------------------------------------*/
	
	final static Logger logger = Logger.getLogger(LinkedListDS.class);
	
	
	/*---------------------------------------------------------------------
    |  Method createQueue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Initializes the metadata elements of a queue structure.
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: metadata elements have been initialized
    |	queue.front = null 
    |	queue.rear = null
    |	queue.count= 0
    |
    |  Parameters: None.
    |
    |  Returns:  void
    | 	
    *-------------------------------------------------------------------*/
	public Queue createQueue()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.debug(getCurrentMethodName() + " Creating new queue... ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		
		return new Queue();
	}
	
	/*---------------------------------------------------------------------
    |  Method enqueue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm inserts data into a queue
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: dataIn has been inserted
    |
    |  Parameters: None.
    |
    |  Returns:  true if successful, false if queue is full
    | 	
    *-------------------------------------------------------------------*/
	public boolean enqueue(Object dataIn, Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		logger.debug(getCurrentMethodName() + "Checking to see if queue is full. ");
		//TODO: Check if the queue is full
		//if queue is full, return false
		
		Node newPtr = new Node();
		newPtr.setData(dataIn);
		newPtr.setNext(null);
		
		// INSERTING INTO A NULL QUEUE
		if (queue.getCount() == 0)
		{
			logger.debug(getCurrentMethodName() + " Queue is empty, setting head node. ");
			queue.setFront(newPtr);
		}
		else
		{
			//INSERT DATA AND ADJUST METADATA
			logger.debug(getCurrentMethodName() + " Inserting value into queue.");
			queue.getRear().setNext(newPtr);
		}
		
		logger.debug(getCurrentMethodName() + " Setting new queue rear pointer.");
		queue.setRear(newPtr);
		logger.debug(getCurrentMethodName() + " Incrementing queue count. ");
		queue.setCount(queue.getCount() + 1);
		
		logger.trace(getCurrentMethodName() + " Exiting ");
		
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method fullQueue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm checks to see if a queue is full. The queue is 
    |	full if memory cannot be allocated for another node.
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: None.
    |
    |  Parameters: None.
    |
    |  Returns:  true if queue is full, false if room for another node
    | 	
    *-------------------------------------------------------------------*/
	/*---------------------------------------------------------------------
	//TODO: Determine if the queue is full
	//public boolean fullQueue()
	//{
	//	
	//}
	 * 
	 ---------------------------------------------------------------------*/
	
	/*---------------------------------------------------------------------
    |  Method dequeue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm deletes a node from a queue
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: data at front of queue returned to the user through 
    |	item and front element deleted and recycled
    |
    |  Parameters: None.
    |
    |  Returns:  true if successful, false if underflow
    | 	
    *-------------------------------------------------------------------*/
	public boolean dequeue(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if(queue.getCount() == 0)
		{
			logger.debug(getCurrentMethodName() + " Queue is empty, returning false ");
			return false;
		}
		
		//DELETE THE DATA
		logger.debug(getCurrentMethodName() + " Setting front of queue to null. ");
		Node t = queue.getQuehead().getFront();
		t.setData(null);
		
		if(queue.getCount() == 1)
		{
			//DELETE THE ONLY ITEM IN THE QUEUE
			logger.debug(getCurrentMethodName() + " Queue only has one node, returning value. ");
			queue.setRear(null);
		}
		
		queue.setFront(queue.getFront().next);
		queue.setCount(queue.getCount()-1);
		
		logger.debug(getCurrentMethodName() + " Returning value from queue. ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method queueFront()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm retrieves the data at the front of the queue 
    |	without changing the queue contents
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: data is passed back to the caller
    |
    |  Parameters: None.
    |
    |  Returns:  true if successful, false if underflow
    | 	
    *-------------------------------------------------------------------*/
	public Object queueFront(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if( isEmpty(queue) == true)
		{
			logger.debug(getCurrentMethodName() + " Queue is empty. Returning null.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return null;
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Queue is not empty. Returning front. ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return queue.getQuehead().getFront().data;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method printQueue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm retrieves the data at the front of the queue
    |	without changing the queue contents
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: data bassed back to caller
    |
    |  Parameters: None.
    |
    |  Returns:  true if successful, false if underflow
    | 	
    *-------------------------------------------------------------------*/
	public void printQueue(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		logger.debug(getCurrentMethodName() + " Getting front of the queue head.");
		Node t = queue.getQuehead().getFront();
		
		if( isEmpty(queue) == true)
		{
			logger.debug(getCurrentMethodName() + " Stack and empty. Not printing anything.");
			System.out.print("Stack is empty.");
		}

		else
		{
			logger.debug(getCurrentMethodName() + " Queue is not empty. Printing...");
			while (t != null )
			{
				System.out.print("[" + t.getData() + "] " + t.hashCode() + " <- ");

				t = t.getNext();
			}
			System.out.println("\n");
		}
		logger.trace(getCurrentMethodName() + " Exiting ");
	}
	
	/*---------------------------------------------------------------------
    |  Method queueCount()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Returns the number of elements in the queue.
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: None.
    |
    |  Parameters: None.
    |
    |  Returns:  queue count
    | 	
    *-------------------------------------------------------------------*/
	public int queueCount(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return queue.getCount();
	}
	
	/*---------------------------------------------------------------------
    |  Method emptyQueue()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm checks to see if queue is empty.
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: None.
    |
    |  Parameters: None.
    |
    |  Returns: true if empty, fals if queue has data.
    | 	
    *-------------------------------------------------------------------*/
	public boolean emptyQueue(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if (queueCount(queue) == 0 )
		{
			logger.trace(getCurrentMethodName() + " Exiting ");
			return true;
		}
		else
		{
			logger.trace(getCurrentMethodName() + " Exiting ");
			return false;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method isEmpty()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm checks to see if a queue is empty.
    |
    |  Pre-condition: queue is a metadata structure
    |
    |  Post-condition: None.
    |
    |  Parameters: None.
    |
    |  Returns:  true if empty, false if not empty
    | 	
    *-------------------------------------------------------------------*/
	public boolean isEmpty(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if (queueCount(queue) == 0 )
		{
			logger.debug(getCurrentMethodName() + " Queue is empty, returning true.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return true;
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Queue is not empty. Returning false.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return false;
		}
	}
	
	public class Queue
	{
		queueHead quehead;
		
		Queue()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			this.quehead = new queueHead();
		}	
	
		
		private queueHead getQuehead() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning Queue head.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead;
		}

		private void setQuehead(queueHead quehead) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting queue head.");
			this.quehead = quehead;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		private int getCount()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning queue head count.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getCount();
		}
		
		private void setCount(int i)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting queue head count to " + i);
			quehead.setCount(i);
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		private void setFront(Node node)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting front of queue head.");
			quehead.setFront(node);
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		private Node getFront()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning front of queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getFront();
		}
		
		private Node getRear()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Getting rear of the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getBack();
		}
		
		private void setRear(Node node)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting rear of queue.");
			quehead.setBack(node);
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
	}
	
	private class queueHead
	{
		private Node front;
		private Node back;
		private int count;
		
		public Node getFront() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning front of the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return front;
		}

		public void setFront(Node front) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting front of the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			this.front = front;
		}

		public Node getBack() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning back of the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return back;
		}

		public void setBack(Node back) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting back of the queue.");
			this.back = back;
			logger.trace(getCurrentMethodName() + " Exiting ");	
		}

		public int getCount() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Returning count of queue");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return count;
		}

		public void setCount(int count) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting count of the queue: " + count);
			this.count = count;
			logger.trace(getCurrentMethodName() + " Exiting ");	
		}

		queueHead()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Creating empty queue head.");
			front = null;
			back = null;
			count = 0;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
	}
	
	private class Node
	{
		private Node next;
		// data carried by this node.
		// could be of any type you need.
		private Object data;
		
		// Node constructor
		public Node()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Creating an empty node.");
			next = null;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		public Node getNext() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Getting the next value in the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return next;
		}

		public void setNext(Node next) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting the next node in the queue :" + next);
			this.next = next;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		public Object getData() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Gettting the data from the queue.");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return data;
		}

		public void setData(Object data) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.debug(getCurrentMethodName() + " Setting the data on the queue.");
			this.data = data;
			logger.trace(getCurrentMethodName() + " Exiting ");
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
