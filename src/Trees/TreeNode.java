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
public interface TreeNode {

		
	/**
	 * 
	 * @param node
	 */
	public void setLeft(TreeNode node);
	
	
	/**
	 * 
	 * @return
	 */
	public TreeNode getLeft();
	
	
	/**
	 * 
	 * @param node
	 */
	public void setRigth(TreeNode node);
	
	
	/**
	 * 
	 * @return
	 */
	public TreeNode getRight();
	
	
	/**
	 * 
	 * @return
	 */
	public TreeNode clone();
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isEqual(TreeNode node);
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLessThan(TreeNode node);	
	
	
	/**
	 * 
	 * @return
	 */
	public String toString();
}