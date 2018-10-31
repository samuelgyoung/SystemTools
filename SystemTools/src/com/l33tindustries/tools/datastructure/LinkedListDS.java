package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;

public class LinkedListDS 
{
	// ---
	// Reference:
	// - http://www.mycstutorials.com/articles/data_structures/linkedlists
	// ---
	
	final static Logger logger = Logger.getLogger(LinkedListDS.class);
	
	private Node head;
	private int count;
	
	private int SearchCount = 0;
	
	public void setSearchCount(int searchCount) 
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		this.SearchCount = searchCount;
	}
	
	public boolean isEmpty()
	{
		logger.trace(getCurrentMethodName() + " Entering ");

		if (head == null)
		{
			logger.trace(getCurrentMethodName() + " Exiting : true");
			return true;
		}
		else
		{
			logger.trace(getCurrentMethodName() + " Exiting : false");
			return false;
		}
	}
	
	public int getSearchCount() {
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return this.SearchCount;
	}
	
	/**
	 * @return the count
	 */
	public int getCount() 
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return this.count;
	}

	public LinkedListDS()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		createList();
		logger.trace(getCurrentMethodName() + " Exiting ");
	}
	
	/*---------------------------------------------------------------------
    |  Method createList()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Initializes metadata for linked list.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Parameters: None
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	public boolean createList()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		logger.debug(getCurrentMethodName() + " Setting head to null.");
		head = null;
		
		logger.debug(getCurrentMethodName() + " Setting count to 0.");
		count = 0;
		
		logger.trace(getCurrentMethodName() + " Exiting : true");
		
		return true;
	}
	
	public boolean deleteLast()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		deleteNode(getLast());

		logger.trace(getCurrentMethodName() + " Exiting : true ");
		return true;
	}
	
	public boolean deleteFirst()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		deleteNode(head);
		logger.trace(getCurrentMethodName() + " Exiting : true " );
		return true;
	}
	
	public boolean insertFirst(Object dataIn)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		insertNode(dataIn, null);
		
		logger.trace(getCurrentMethodName() + " Exiting : true ");
		
		return true;
	}
	
	public void insertLast(Object dataIn)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		//logger.debug(getCurrentMethodName() + " Getting the last node.");
		//getLast();
		
		insertNode(dataIn, getLast());
		logger.trace(getCurrentMethodName() + " Exiting ");
		
	}
	
	public Node getFirst()
	{	logger.trace(getCurrentMethodName() + " Entering ");
		logger.trace(getCurrentMethodName() + " Exiting : " + head.hashCode());
		return head;
	}
	
	public Node getLast()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		if(isEmpty()) {
			logger.debug(getCurrentMethodName() + " Starting with null head node");

		}
		else 
		{
			logger.debug(getCurrentMethodName() + " Starting with node : " + head.hashCode());
		}

		Node t = head;
	
		if ( count == 0 )
		{
			logger.debug(getCurrentMethodName() + " Count is 0 for linked list, no last node to return. ");
			logger.trace(getCurrentMethodName() + " Exiting : null");
			return null;
		}
		
		
		for (int i = 0; i < count-1; i++)
		{

			logger.debug(getCurrentMethodName() + " Node:  " + t.hashCode() + " is not the last node. Trying the next node.");
			t = t.getNext();
		}
		
		logger.trace(getCurrentMethodName() + " Found the last node, returning: " + t.hashCode());
		return t;
	}
	
	/*---------------------------------------------------------------------
    |  Method getNode()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Returns the node in the order of the number passed in.
    |			 Returns nothing if list is empty.
    |
    |  Pre-condition:  	None.
    |
    |  Post-condition: 	Returns the node at the number passed in.
    |
    |  Returns: null
    *-------------------------------------------------------------------*/
	public Node getNode(int nodeNumber)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		//8/23/16: if(head == null)
		if(isEmpty())
		{
			logger.debug(getCurrentMethodName() + " Head equals null, no node to return. ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return null;
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Head does not equals null, so there is a node to return.");
			
			if(nodeNumber > count)
			{
				logger.debug(getCurrentMethodName() + " Node number is greater than count. Setting to the search to number of nodes. ");
				nodeNumber = count;
			}
			
			logger.debug(getCurrentMethodName() + " Starting to traverse from the first node. ");
			Node t = head;
			
			for (int i = 0; i < nodeNumber-1; i++)
			{
				logger.debug(getCurrentMethodName() + " Running through node : " + t.hashCode() + " going to the next node.");
				t = t.getNext();
			}

			
			logger.debug(getCurrentMethodName() + "Found the node : " + t.hashCode());
			logger.trace(getCurrentMethodName() + " Exiting " + t.hashCode());			
			return t;
		}
	}
		
	/*---------------------------------------------------------------------
    |  Method printLinkedList()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Prints the linked list in the class
    |
    |  Pre-condition:  	None.
    |
    |  Post-condition: 	Prints the linked list to standard out.
    |
    |  Returns: null
    *-------------------------------------------------------------------*/
	public void printLinkedList()
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		//8/23/16: if(head == null)
		if(isEmpty())
		{
			System.out.println("List is empty, nothing to print.");
		}
		else
		{
			Node t = head;
		
			//8/1/16 : for (int i = 0; i < count; i++)
			while (t != null )
			{
				//8/1/16 : System.out.print("locn: " + i + " , data: [" + t.getData() + "] -> ");
				System.out.print("[" + t.getData() + "] " + t.hashCode() + " -> ");

				t = t.getNext();
			}
			
			
			System.out.println();
		}
		
		logger.trace(getCurrentMethodName() + " Exiting ");
	}
	
	/*---------------------------------------------------------------------
    |  Method insertNode()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Inserts data into a new node in the linked list.
    |
    |  Pre-condition:  	dataIn contains data to be inserted
    |					pPre is the pointer to the data's logical predecessor
    |					if pPre is null, it's set at the beginning
    |
    |  Post-condition: 	data has been inserted into the sequence
    |
    |  Returns: true if successful, false if memory overflow
    *-------------------------------------------------------------------*/
	public boolean insertNode(Object dataIn, Node pPre)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		logger.debug(getCurrentMethodName() + " Adding data : " + dataIn);
		
		Node pNew = new Node(dataIn);
		
		logger.debug(getCurrentMethodName() + " New node created: " + pNew.hashCode());

		if(pPre == null)
		{			
			if (head == null)
			{
				logger.debug(getCurrentMethodName() + " Empty list, creating first node.");

			}
			else
			{
				logger.debug(getCurrentMethodName() + " Setting head " + head.hashCode() + " as next for new head node: " + pNew.hashCode() + " and putting new node in the front.");
			}
			
			logger.debug(getCurrentMethodName() + " Setting in front of head.");
			pNew.setNext(head);
			head = pNew;
			
		}
		else
		{
			logger.debug(getCurrentMethodName() + " List is not empty. ");

			pNew.setNext(pPre.getNext());
			pPre.setNext(pNew);
		}
		
		count = count + 1;
		
		logger.trace(getCurrentMethodName() + " Exiting ");

		return true;
	}
	
	/*---------------------------------------------------------------------
    |  Method deleteNode()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Deletes data from a linked list and returns it to calling module.
    |
    |  Pre-condition:  pLoc is a pointer to node to be deleted
    |
    |  Post-condition: Data has been deleted and returned to the caller
    |
    |  Parameters: None
    |
    |  Returns: Data from the deleted node (Object)
    *-------------------------------------------------------------------*/
	public Object deleteNode(Node pLoc)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		logger.debug(getCurrentMethodName() + " Looking to delete " + pLoc.hashCode());

		
		if(pLoc == head)
		{
			logger.debug(getCurrentMethodName() + " Destination deletion node is the head. Setting the next node as the new head.");
			head = pLoc.getNext();
			count = count - 1;
		}
		
		else
		{
			logger.debug(getCurrentMethodName() + " Starting from the first node, and searching for the node to delete.");
			Node pPre = head;

			while(pPre.getNext() != pLoc)
			{
				pPre = pPre.getNext(); 
				
				logger.debug(getCurrentMethodName() + " next " + pPre.getNext().hashCode() + " target " + pLoc.hashCode());				
			}
			
			if(pLoc.getNext() == null)
			{
				logger.debug(getCurrentMethodName() + " Setting Node " + pPre.hashCode() + " next to null");

			}
			else
			{
				logger.debug(getCurrentMethodName() + " Setting Node " + pPre.hashCode() + " next to " + pLoc.getNext().hashCode());
			}
			
			pPre.setNext(pLoc.getNext());
			
			count = count - 1;
			
			return pPre.getData();
		}
		
		//count = count - 1;
		pLoc = null;
		
		logger.trace(getCurrentMethodName() + " Exiting : " + null);
		
		return null;
	}
	
	/*---------------------------------------------------------------------
    |  Method searchList()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  	Searches list and passes back address of node containing
    |				target and its logical predecessor.
    |
    |  Pre-condition:  target is the data being sought
    |
    |  Post-condition: 
    |
    |  Parameters: None
    |
    |  Returns: true if found, false if not found
    *-------------------------------------------------------------------*/	
	public <T extends Comparable<T>> boolean searchList(T target)
	{
		setSearchCount(0);
		
		if(head == null)
		{
			System.out.println("List is empty.");
			return false;
		}
		else
		{
			Node t = head;
		
			while (t != null )
			{
				
				setSearchCount(getSearchCount() + 1);
				
				if(target.equals(t.getData()))
				{
					return true;
				}

				t = t.getNext();
			}
		
			return false;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method emptylist()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Returns Boolean indicating whether the list is empty.
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Returns: true if list is empty, false if list contains data
    *-------------------------------------------------------------------*/
	public boolean emptyList()
	{
		if(getCount() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method listCount()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Gets the count on the list
    |
    |  Pre-condition:  None
    |
    |  Post-condition: None
    |
    |  Returns: Integer representing number of nodes in list.
    *-------------------------------------------------------------------*/
	private int listCount()
	{	
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting : " + this.count);
			return this.count;
	}
		
	/*---------------------------------------------------------------------
    |  Method addNode()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Add data to linked list.
    |
    |  Pre-condition:  Data matches what can be inserted into the array
    |
    |  Post-condition: data have been inserted into list in key sequences
    |
    |  Returns: True if inserted, False if not inserted
    *-------------------------------------------------------------------*/
	public <T extends Comparable<T>> boolean addNode(T dataIn, Node pPre)
	{
		logger.trace(getCurrentMethodName() + " Entering ");
		
		boolean found = searchList(dataIn);
		
		if (found)
		{
			logger.debug(getCurrentMethodName() + " Data already in Linked List. Exiting : false ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return false;
		}
		else
		{
			boolean success = insertNode(dataIn, pPre);
			
			if(success == false)
			{
				logger.debug(getCurrentMethodName() + " Error! LinkedList Out of memory! ");
				logger.trace(getCurrentMethodName() + " Exiting ");
				return false;
			}	
		}
		logger.debug(getCurrentMethodName() + " Successfully Inserted data into Linked List! ");
		logger.trace(getCurrentMethodName() + " Exiting ");
		return true;
	}
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;
		

		// Node constructor
		public Node(Object _data)
		{
			next = null;
			data = _data;
		}
		
		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object _data, Node _next)
		{
			next = _next;
			data = _data;
		}
		
		// these methods should be self-explanatory
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
	}
	
	//Used for debug.
	private static String getCurrentMethodName() 
 	{ 
 		StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace(); 
 		
 		return 	stackTraceElements[1].toString().replaceFirst(stackTraceElements[1].toString().split("\\.")[0]+"\\.", "");
 	}
}
