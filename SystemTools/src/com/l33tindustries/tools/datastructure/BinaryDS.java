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
	
	BinaryDS()
	{
		this.QueueDS_001 = new QueueDS();
		this.queue_001 = QueueDS_001.createQueue();
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

	private class Node
	{
		private Node leftSubTree;
		private Node rightSubTree;
		private Object data;
		
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
