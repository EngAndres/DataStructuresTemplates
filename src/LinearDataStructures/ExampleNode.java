package LinearDataStructures;

/*
# Example of a Node for list.
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
 * This class represents the behavior of an Example of a Node for list
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class ExampleNode implements Node {

	public int value;
	public ExampleNode next = null;
	
	
	/**
	 * 
	 * @param value
	 */
	public ExampleNode(int value) 
	{
		this.value = value;
	}
	
	@Override
	public void setNext(Node node) 
	{
		next = (ExampleNode)node;
	}

	@Override
	public Node getNext() 
	{
		return next;
	}

	@Override
	public Node clone() 
	{
		return new ExampleNode(this.value);
	}

	@Override
	public boolean isEqual(Node node) 
	{
		ExampleNode temp = (ExampleNode)node;
		return this.value == temp.value ? true : false;
	}

	@Override
	public boolean isLessThan(Node node) 
	{
		ExampleNode temp = (ExampleNode)node;
		return this.value < temp.value ? true : false;
	}
	
	@Override
	public String toString()
	{
		return this.value + ",";
	}
}