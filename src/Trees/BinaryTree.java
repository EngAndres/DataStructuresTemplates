package Trees;


/*
# Binary Tree Data Structure.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Binary Trees
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BinaryTree {
	
	BinaryNode root = null; //
	 
	/**
	 * 
	 */
	public BinaryTree() {}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void insert(int value)
	{
		if(isEmpty())
		{
			BinaryNode newNode = new BinaryNode(value);
			root = newNode;
		}
		else
		{
			BinaryNode temp = root;
			BinaryNode parent = root;
			
			while(temp != null)
			{
				parent = temp;
				if(value < temp.value)
					temp = (BinaryNode)temp.getLeft();
				else
					temp = (BinaryNode)temp.getRight();
			}
			
			BinaryNode newNode = new BinaryNode(value);
			
			if(value < parent.value)
				parent.setLeft(newNode);
			else
				parent.setRigth(newNode);
		}
	}
	
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public BinaryNode search(int value)
	{
		return null;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void delete(int value)
	{
		
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLeaf(BinaryNode node)
	{
		return (node.getLeft() == null && node.getRight() == null) ? true : false;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean oneChild(TreeNode node)
	{
		return (node.getLeft() != null && node.getRight() != null) ? false : true;
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void preorder(BinaryNode node)
	{
		if(node != null)
		{
			System.out.print(node.toString() + " ");
			preorder((BinaryNode)node.getLeft());
			preorder((BinaryNode)node.getRight());
		}
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void postorder(TreeNode node)
	{
	}
	
	
	/**
	 * 
	 * @param node
	 */
	public void inorder(TreeNode node)
	{
	}
}