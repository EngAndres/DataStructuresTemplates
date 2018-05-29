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
public class BinaryNodeExample implements BinaryTreeNode {

	public int value;
	public BinaryNodeExample left;
	public BinaryNodeExample right;
	
	public  BinaryNodeExample(int value)
	{
		this.value = value;
	}
	
	
	@Override
	public void setLeft(BinaryTreeNode node) 
	{
		left = (BinaryNodeExample)node;
	}

	
	@Override
	public BinaryTreeNode getLeft() 
	{
		return left;
	}

	
	@Override
	public void setRight(BinaryTreeNode node)
	{
		right = (BinaryNodeExample)node;
	}

	
	@Override
	public BinaryTreeNode getRight() 
	{
		return right;
	}

	
	@Override
	public BinaryTreeNode clone()
	{
		return null;
	}

	
	@Override
	public boolean isEqual(BinaryTreeNode node) 
	{
		return false;
	}

	@Override
	public boolean isLessThan(BinaryTreeNode node)
	{
		return false;
	}
}