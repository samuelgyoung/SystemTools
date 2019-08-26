package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;


public class QueueDS 
{
	/* Queue Notes: 
	 * - Inserted at the rear and deleted at the front
	 * - This makes queues FIFO
	 * - Inserting is known as enquque
	 * - Deleting is dequeuing
	 * - Queue Front returns the data from the front of the queue
	 * - If therre is no data in the queue, it's in a queue underflow state
	 * - The queue head requires two pointers and a counter
	 */

	final static Logger logger = Logger.getLogger(LinkedListDS.class);
	
	public Queue createQueue()
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		logger.trace(getCurrentMethodName() + " Exiting ");
		
		return new Queue();
	}
	
	public boolean enqueue(Object dataIn, Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		//TODO: Check if the queue is full
		
		Node newPtr = new Node();
		newPtr.setData(dataIn);
		newPtr.setNext(null);
		
		// INSERTING INTO A NULL QUEUE
		if (queue.getCount() == 0)
		{
			queue.setFront(newPtr);
		}
		else
		{
			//INSERT DATA AND ADJUST METADATA
			queue.getRear().setNext(newPtr);
		}
		
		queue.setRear(newPtr);
		queue.setCount(queue.getCount() + 1);
		
		logger.trace(getCurrentMethodName() + " Exiting ");
		
		return true;
	}
	
	//TODO: Determine if the queue is full
	//public boolean fullQueue()
	//{
	//	
	//}
	
	public boolean dequeue(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if(queue.getCount() == 0)
		{
			return false;
		}
		
		//DELETE THE DATA
		Node t = queue.getQuehead().getFront();
		t.setData(null);
		
		if(queue.getCount() == 1)
		{
			//DELETE THE ONLY ITEM IN THE QUEUE
			queue.setRear(null);
		}
		
		queue.setFront(queue.getFront().next);
		queue.setCount(queue.getCount()-1);
		
		logger.trace(getCurrentMethodName() + " Exiting ");
		return true;
	}
	
	public Object queueFront(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		if( isEmpty(queue) == true)
		{
			logger.trace(getCurrentMethodName() + " Exiting ");
			return null;
		}
		else
		{
			logger.trace(getCurrentMethodName() + " Exiting ");
			return queue.getQuehead().getFront().data;
		}
	}
	
	public void printQueue(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		Node t = queue.getQuehead().getFront();
		
		if( isEmpty(queue) == true)
		{
			System.out.print("Stack is empty.");
		}

		else
		{
			while (t != null )
			{
				System.out.print("[" + t.getData() + "] " + t.hashCode() + " <- ");

				t = t.getNext();
			}
			System.out.println("\n");
		}
		logger.trace(getCurrentMethodName() + " Exiting ");
	}
	
	public int queueCount(Queue queue)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return queue.getCount();
	}
	
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
	
	public boolean isEmpty(Queue queue)
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
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead;
		}

		private void setQuehead(queueHead quehead) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.quehead = quehead;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		private int getCount()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getCount();
		}
		
		private void setCount(int i)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			quehead.setCount(i);
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		private void setFront(Node node)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			quehead.setFront(node);
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		private Node getFront()
		{
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getFront();
		}
		
		private Node getRear()
		{
			logger.trace(getCurrentMethodName() + " Entering ");

			logger.trace(getCurrentMethodName() + " Exiting ");
			return quehead.getBack();
		}
		
		private void setRear(Node node)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
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
			logger.trace(getCurrentMethodName() + " Exiting ");
			return front;
		}

		public void setFront(Node front) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			this.front = front;
		}

		public Node getBack() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return back;
		}

		public void setBack(Node back) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.back = back;
			logger.trace(getCurrentMethodName() + " Exiting ");	
		}

		public int getCount() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return count;
		}

		public void setCount(int count) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.count = count;
			logger.trace(getCurrentMethodName() + " Exiting ");	
		}

		queueHead()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
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
			next = null;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		public Node getNext() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return next;
		}

		public void setNext(Node next) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.next = next;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}

		public Object getData() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return data;
		}

		public void setData(Object data) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
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
