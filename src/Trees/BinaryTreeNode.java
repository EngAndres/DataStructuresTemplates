package Trees;


/*
# Abstraction of a Tree Node.
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
 * This class represents the behavior of a Tree Node Abstraction
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public interface BinaryTreeNode {

		
	/**
	 * 
	 * @param node
	 */
	public void setLeft(BinaryTreeNode node);
	
	
	/**
	 * 
	 * @return
	 */
	public BinaryTreeNode getLeft();
	
	
	/**
	 * 
	 * @param node
	 */
	public void setRight(BinaryTreeNode node);
	
	
	/**
	 * 
	 * @return
	 */
	public BinaryTreeNode getRight();
	
	
	/**
	 * 
	 * @return
	 */
	public BinaryTreeNode clone();
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isEqual(BinaryTreeNode node);
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLessThan(BinaryTreeNode node);	
	
	
	/**
	 * 
	 * @return
	 */
	public String toString();
}