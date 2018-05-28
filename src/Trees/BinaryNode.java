package Trees;

/*
# Binary Tree Node.
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
 * This class represents the behavior of Binary Tree Node
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BinaryNode implements TreeNode {

	public int value;
	public BinaryNode left;
	public BinaryNode right;
	
	public  BinaryNode(int value)
	{
		this.value = value;
	}
	
	
	@Override
	public void setLeft(TreeNode node) 
	{
		left = (BinaryNode)node;
	}

	
	@Override
	public TreeNode getLeft() 
	{
		return left;
	}

	
	@Override
	public void setRigth(TreeNode node)
	{
		right = (BinaryNode)node;
	}

	
	@Override
	public TreeNode getRight() 
	{
		return right;
	}

	
	@Override
	public TreeNode clone()
	{
		return null;
	}

	
	@Override
	public boolean isEqual(TreeNode node) 
	{
		return false;
	}

	@Override
	public boolean isLessThan(TreeNode node)
	{
		return false;
	}
}