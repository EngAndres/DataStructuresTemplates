package MotifSearch;
import LinearDataStructures.Node;


/*
# Node of a List of Experimental DNA Sequences.
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
 * This class represents the behavior of an Experimental Sequence Node
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Sequence implements Node {
	
	public String sequence; //
	public String chromosome; //
	public int start; //
	public int end; //
	private Node next = null; //
	
	
	/**
	 * 
	 */
	public Sequence() {};
	
	
	/**
	 * 
	 * @param sequence
	 * @param chromosome
	 * @param start
	 * @param end
	 */
	public Sequence(String sequence, String chromosome, int start, int end)
	{
		this.sequence = sequence;
		this.chromosome = chromosome;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString()
	{
		return "Sequence: " + this.sequence + "\t Chromosome: " + this.chromosome
				+ "\t Start: " + this.start+ "\t End: " + this.end+ "\n";
	}
	
	@Override
	public Node clone()
	{
		Sequence clone = new Sequence(this.sequence, this.chromosome, this.start, this.end);
		return clone;
	}

	@Override
	public void setNext(Node node) 
	{
		next = node;
	}

	@Override
	public Node getNext() 
	{
		return this.next;
	}

	@Override
	public boolean isEqual(Node node)
	{
		Sequence temp = (Sequence)node;
		return (this.sequence.equals(temp.sequence) && this.chromosome.equals(temp.chromosome) && this.start == temp.start && this.end == temp.end) ? true : false;
	}

	@Override
	public boolean isLessThan(Node node)
	{
		return false;
	}
}