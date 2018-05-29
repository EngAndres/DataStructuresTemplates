package Trees;


/*
# Recovery Node to rebuild a tree based on tree traversals.
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
 * This class represents the behavior of a Recovery Node to rebuild a tree based on tree traversals
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class RecoveryNode implements BinaryTreeNode {

	/*
	 * 
	 */
	public String value;
	public RecoveryNode left = null;
	public RecoveryNode right = null;
	
	
	public RecoveryNode(String value)
	{
		this.value = value;
	}
	
	
	@Override
	public void setLeft(BinaryTreeNode node) 
	{
		this.left = (RecoveryNode)node;	
	}

	
	@Override
	public BinaryTreeNode getLeft() 
	{
		return this.left;
	}

	
	@Override
	public void setRight(BinaryTreeNode node) 
	{
		this.right = (RecoveryNode)node;
	}

	
	@Override
	public BinaryTreeNode getRight() 
	{
		return this.right;
	}

	
	@Override
	public BinaryTreeNode clone() 
	{
		return new RecoveryNode(this.value);
	}

	
	@Override
	public boolean isEqual(BinaryTreeNode node) 
	{
		RecoveryNode temp = (RecoveryNode)node;
		return this.value.equals( temp.value ) ? true : false;
	}

	
	@Override
	public boolean isLessThan(BinaryTreeNode node) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		return this.value;
	}
}