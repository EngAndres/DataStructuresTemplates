package Strings;

import LinearDataStructures.Node;

/*
# String Node for Strings based on Lists.
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
 * This class represents the behavior of a String Node for Strings based on Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringNode implements Node {

	/*
	 * 
	 */
	char character;
	Node next = null;
	
	public StringNode(char character) 
	{
		this.character = character;
	}

	
	@Override
	public void setNext(Node node) 
	{
		this.next = node;
	}

	
	@Override
	public Node getNext() 
	{
		return this.next;
	}

	
	@Override
	public Node clone() 
	{
		StringNode clone = new StringNode(this.character);
		return clone;
	}

	
	@Override
	public boolean isEqual(Node node)
	{
		StringNode temp = (StringNode) node;
		return temp.character == this.character ? true : false;
	}

	
	@Override
	public boolean isLessThan(Node node) 
	{
		StringNode temp = (StringNode) node;
		return (int)this.character < (int)temp.character ? true : false;
	}
}