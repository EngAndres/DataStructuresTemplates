package LinearDataStructures;

/*
# Interface of a Generic Node.
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
 * This class represents the behavior of an Interface of a Generic Node
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public interface Node {
	
	Node next = null; //Pointer
	
	/**
	 * 
	 * @return
	 */
	public String toString();
	
	
	/**
	 * 
	 * @param node
	 */
	public void setNext(Node node);
	
	
	/**
	 * 
	 * @return
	 */
	public Node getNext();
	
	
	/**
	 * 
	 * @return
	 */
	public Node clone();
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isEqual(Node node);
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLessThan(Node node);
}