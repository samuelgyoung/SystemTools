package com.l33tindustries.tools.datastructure;

import org.apache.log4j.Logger;

import com.l33tindustries.tools.datastructure.QueueDS.Queue;

public class BinaryDS 
{
	final static Logger logger = Logger.getLogger(LinkedListDS.class);
	
	/*
	 * Binary Tree Notes:
	 * 	- No node can have more than two subtrees
	 *  - The max height of a binary tree is: N nodes = max height
	 *  - The min height of a binary tree is: [log2 N] + 1
	 *  - Given the Height of a binary tree (H), the minimum and maximum number of nodes in the tree:
	 *  	- N(min) = H
	 *  	- N(max) = 2^H-1
	 *  - The shorter the tree, the easier it is to find the desired node
	 *  	- Thus, you want a balanced b-tree
	 *  	- Balance Factor is the difference between the left and right subtrees
	 *  		- If we determine the height of the left subtree (HL) and the height of the
	 *  			right subtree (HR), the balance factor (B) is determined by : B = HL - HR
	 *  	- Generally, a tree is balanced if the height of its subtrees differenes by no more than
	 *  		one (-1,0,1) and it's subtrees are also balanced
	 *  	- This definition was created by Adelson-Veskii and Landis in the def of AVL trees
	 *   - A complete tree has the max number of entries for its height.
	 *   - The max number if reached when the last level is full
	 *   - A tree is nearly complete if it has a min height for it's nodes (H(min)) and all nodes in the last level
	 *   	are found on the left
	 *   - Tree traversals require each node be processed once and only once.
	 *   	- depth-first approach: process all of the descendents of a child before going to the next child
	 *   		- There are 3 traversals (in liturature, 6 total)
	 *   			- Preorder : root processed first, then left subtree, then right subtree
	 *   			- Inorder : processes the left side first, then root, then right
	 *   			- Postorder : processes the left side first, then right, then root
	 *   	- breadth first approach: each level is completely processed before the next level is started
	 */ 
	
	QueueDS QueueDS_001;
	Queue queue_001;
	
	Node rootNode;
	
	public BinaryDS()
	{
		this.QueueDS_001 = new QueueDS();
		this.queue_001 = QueueDS_001.createQueue();
		
		//this.rootNode = new Node();
	}	
	
	public BinaryDS(Object data)
	{
		this.QueueDS_001 = new QueueDS();
		this.queue_001 = QueueDS_001.createQueue();
		
		this.rootNode = new Node(data);
	}	
	
	public Node getRootNode()
	{
		return rootNode;
	}
	
	//DEPTH FIRST TRAVERSALS ______________________________________________
	/*---------------------------------------------------------------------
    |  Method preOrder()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Traverse a binary tree in a node-left-right sequence.
    |	preOrder processes the root, then left, then right
    |
    |  Pre-condition:  Root is the entry node of a tree or subtree
    |
    |  Post-condition: each node had been processed in order
    |
    |  Parameters: root node pointer
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	private void preOrder(Node node)
	{
		if (node != null)
		{
			//process(node.data) //DO STUFF TO THE NODE (WE ARE JUST TRAVERSING)
			preOrder(node.getLeftSubTree());
			preOrder(node.getRightSubTree());
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method inOrder()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Traverse a binary tree in left-node-right squence.
    |  inOrder processes the left side first, then root, then right
    |
    |  Pre-condition:  root is the entry node of a tree or subtree
    |
    |  Post-condition: each node has been processed in order
    |
    |  Parameters: root node pointer
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	private void inOrder(Node node)
	{
		if (node != null)
		{
			inOrder(node.getLeftSubTree());
			//process(node.data) //DO STUFF TO THE NODE (WE ARE JUST TRAVERSING)
			inOrder(node.getRightSubTree());
			
		}
	}
	
	/*---------------------------------------------------------------------
    |  Method postOrder()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Traverse a binary tree in the left-right-node sequence.
    |  postOrder processes the left side first, then right, then root
    |
    |  Pre-condition:  root is the entry node of a tree or subtree
    |
    |  Post-condition: each node has been processed in order
    |
    |  Parameters: root node pointer
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	private void postOrder(Node node)
	{
		if (node != null)
		{
			postOrder(node.getLeftSubTree());
			postOrder(node.getRightSubTree());
			//process(node.data) //DO STUFF TO THE NODE (WE ARE JUST TRAVERSING)
		}
	}
	//END DEPTH FIRST TRAVERSALS __________________________________________

	
	//BREADTH-FIRST TRAVERSALS _____________________________________________
	//TODO: FINISH THIS METHOD
	/*---------------------------------------------------------------------
    |  Method  breadthFirst()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Process tree using breadthFirst-first traversal
    |  breadth-first processes each level
    |
    |  Pre-condition:  root is a pointer to a tree node
    |
    |  Post-condition: tree has been processed
    |
    |  Parameters: root node pointer
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	private void breadthFirst(Node node)
	{
		Node pointer = node;
		while (pointer != null)
		{
			//process(pointer) //DO STUFF TO THE NODE (WE ARE JUST TRAVERSING)
			if(node.getLeftSubTree() != null)
			{			
				this.QueueDS_001.enqueue(pointer.getLeftSubTree(), queue_001);
			}
			else
			{
				
			}
			
			if(node.getRightSubTree() != null)
			{
				this.QueueDS_001.enqueue(pointer.getRightSubTree(), queue_001);
			}
			else
			{
				
			}
			
			//IF THE QUEUE IS NOT EMPTY
			if(this.QueueDS_001.emptyQueue(queue_001) != true)
			{
				//DEQUEUE THE QUEUE TAKING THE CURRENT NODE OUT
				if(this.QueueDS_001.dequeue(queue_001) == true)
				{
					pointer = (Node) this.QueueDS_001.queueFront(queue_001);
				}
			}
			else
			{
				pointer = null;
			}
		}
	}
	
	//END BREADTH-FIRST TRAVERSALS _________________________________________

	//TODO: INFIX NOTATION p.323
	//TODO: CONVERTTOPAREN p.310
	
	
	/*---------------------------------------------------------------------
    |  Method  findSmallestBST()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm finds the smallest node in the BST 
    |	(binary search tree).
    |
    |  Pre-condition:  root is the pointer to the nonempty BST or subtree
    |
    |  Post-condition: none.
    |
    |  Parameters: 
    |
    |  Returns: address of smallest node
    *-------------------------------------------------------------------*/
	public Object findSmallestBST(Node node)
	{
		if(node.getLeftSubTree() == null)
		{
			logger.debug(getCurrentMethodName() + " No more nodes to the left. Found the lowest value in the tree : " + node.getData());
			return node;
		}
		
		logger.debug(getCurrentMethodName() + " Still more nodes to the left. Checking next one... ");
		return findSmallestBST(node.getLeftSubTree());
	}
	
	/*---------------------------------------------------------------------
    |  Method  findLargestBST()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  This algorithm finds the largest node in the BST 
    |	(binary search tree).
    |
    |  Pre-condition:  root is the pointer to the nonempty BST or subtree
    |
    |  Post-condition: none.
    |
    |  Parameters: 
    |
    |  Returns: address of the largest node
    *-------------------------------------------------------------------*/
	public Object findLargestBST(Node root)
	{
		if(root.getRightSubTree() == null)
		{
			logger.debug(getCurrentMethodName() + " No more nodes to the right. Found the highest value in the tree : " + root.getData());
			return root;
		}
		
		logger.debug(getCurrentMethodName() + " Still more nodes to the left. Checking next one... ");
		return findSmallestBST(root.getRightSubTree());
	}
	
	/*---------------------------------------------------------------------
    |  Method  searchBST()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Search a BST for a given value.
    |
    |  Pre-condition:  root is the root to a binary tree or subtree argument is
    |	the key value requested.
    |
    |  Post-condition: none.
    |
    |  Parameters: 
    |
    |  Returns: the node address if the value is found
    |	null if the node is not in the tree
    *-------------------------------------------------------------------*/
	public <T extends Comparable<T>> Node searchBST(Node root, T value)
	{
		
		//Using Comparable allows us to handle different data types (int, character etc...)
		
		if(root == null )
		{
			logger.debug(getCurrentMethodName() + "Node is null. Value wasn't found.");
			return null;
		}
		//if(value < Current Nodes Data), go left
		if(value.compareTo((T) root.getData()) < 0)
		{
			logger.debug(getCurrentMethodName() + " Moving to the left node on the tree... ");
			return searchBST(root.getLeftSubTree(), value);
		}
		//if(value > Current Nodes Data), go right
		else if(value.compareTo((T) root.getData()) > 0)
		{
			logger.debug(getCurrentMethodName() + " Moving to the right node on the tree... ");
			return searchBST(root.getRightSubTree(), value);
		}
		else
		{
			logger.debug(getCurrentMethodName() + " Found the node that contains the value. ");
			return root;
		}	
	}
	
	/*---------------------------------------------------------------------
    |  Method  insertBST()
    |
    |  Author: sgyoung
    |  
    |  Purpose:  Insert node containing new node into BST using iteration.
    |
    |  Pre-condition:  root is the address of first node in BST
    |	new is address of node containing data to be inserted.
    |
    |  Post-condition: new node inserted into the tree
    |
    |  Parameters: 
    |
    |  Returns: 
    *-------------------------------------------------------------------*/
	public <T extends Comparable<T>> void insertBST(Node root, T value)
	{
		if(root == null )
		{
			logger.debug(getCurrentMethodName() + "Node is null. Inserting a new node.");
			root = new Node(value);
		}
		else
		{
			Node nodeWalk = root;
			
			while(nodeWalk != null)
			{
				Node parent = nodeWalk;
				//if(value < Current Nodes Data), go left
				if(value.compareTo((T) nodeWalk.getData()) < 0)
				{
					logger.debug(getCurrentMethodName() + " Comparing : " + value + " " + nodeWalk.getData() + " Going left");
					nodeWalk = nodeWalk.getLeftSubTree();
				}
				else
				{
					logger.debug(getCurrentMethodName() + " Comparing : " + value + " " + nodeWalk.getData() + " Going right");
					nodeWalk = nodeWalk.getRightSubTree();
				}
			}
			logger.debug(getCurrentMethodName() + " Location of new node found for insert.");
			
			//if(value < Current Nodes Data), go left
			if(value.compareTo((T) nodeWalk.getData()) < 0)
			{
				logger.debug(getCurrentMethodName() + " Comparing : " + value + " " + nodeWalk.getData() + " Inserting left");
				nodeWalk.setLeftSubTree(new Node(value));
			}
			else
			{
				logger.debug(getCurrentMethodName() + " Comparing : " + value + " " + nodeWalk.getData() + " Inserting right");
				nodeWalk.setRightSubTree(new Node(value));
			}
		}
	}
	
	private class Node
	{
		private Node leftSubTree;
		private Node rightSubTree;
		private Object data;
		
		public Node(Object data)
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.leftSubTree = null;
			this.rightSubTree = null;
			this.data = data;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		public Node()
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			leftSubTree = null;
			rightSubTree = null;
			logger.trace(getCurrentMethodName() + " Exiting ");
		}
		
		public Node getLeftSubTree() {
			return leftSubTree;
		}

		public void setLeftSubTree(Node leftSubTree) {
			this.leftSubTree = leftSubTree;
		}

		public Node getRightSubTree() {
			return rightSubTree;
		}

		public void setRightSubTree(Node rightSubTree) {
			this.rightSubTree = rightSubTree;
		}

		public Object getData() 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			logger.trace(getCurrentMethodName() + " Exiting ");
			return data;
		}

		public boolean setData(Object data) 
		{
			logger.trace(getCurrentMethodName() + " Entering ");
			this.data = data;
			if(this.data == data)
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
