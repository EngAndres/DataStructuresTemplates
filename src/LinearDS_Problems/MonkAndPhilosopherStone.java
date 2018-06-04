package LinearDS_Problems;

import java.io.*;

import LinearDataStructures.Queue;
import LinearDataStructures.Stack;
import LinearDataStructures.Node;

/*
# Contest Problem: Monk And Philosopher Stone
# https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/monk-and-philosophers-stone
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
 * This class represents the solution of Contest Problem: Monk And Philosopher Stone
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class MonkAndPhilosopherStone {
	
	/**
	 * 
	 *
	 */
	public class ProblemNode implements Node
	{
		public int value;
		public ProblemNode next = null;
		
		/**
		 * 
		 * @param value
		 */
		public ProblemNode(int value) 
		{
			this.value = value;
		}
		
		@Override
		public void setNext(Node node) 
		{
			this.next = (ProblemNode)node;
		}


		@Override
		public Node getNext() 
		{
			return next;
		}


		@Override
		public Node clone() {
			ProblemNode temp = new ProblemNode(this.value);
			return temp;
		}


		@Override
		public boolean isEqual(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.value == temp.value ? true : false;
		}


		@Override
		public boolean isLessThan(Node node) 
		{
			ProblemNode temp = (ProblemNode)node;
			return this.value < temp.value ? true : false;
		}
		
		public String toString()
		{
			return " " + this.value;
		}
	}
	
	/**
	 * 
	 */
	public MonkAndPhilosopherStone() {}
	
	
	/**
	 * 
	 * @return
	 */
	public String solution() 
	{
		String response = null;
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
				
		try
		{
			int coinsHarryBag = 0, coinsMonkBag = 0;
			int desireMonk = 0, instructions = 0;
			int counter = -1;
			String[] input = null;
			String instruction;
			
			Queue harryBag = new Queue();
			Stack monkBag = new Stack();
			
			coinsHarryBag = Integer.parseInt( br. readLine() );
			input = br.readLine().split(" ");
			
			for(int i = 0; i < coinsHarryBag; i++)
				harryBag.enqueue(new ProblemNode( Integer.parseInt( input[i] ) ));
			
			
			input = br.readLine().split(" ");
			instructions = Integer.parseInt( input[0] );
			desireMonk = Integer.parseInt( input[1] );
			
			ProblemNode coin = null;
			
			for(int i = 0; i < instructions; i++)
			{
				instruction = br.readLine();
				
				if(instruction.equals("Harry"))
				{
					coin = (ProblemNode)harryBag.dequeue();
					monkBag.push( coin );
					coinsMonkBag += coin.value;

					if(coinsMonkBag == desireMonk)
					{
						counter = 0;
						
						while(!monkBag.isEmpty())
						{
							counter += 1;
							coin = (ProblemNode)monkBag.pop();
						}
						
						break;
					}
				}
				else
				{
					coin = (ProblemNode)monkBag.pop();
					coinsMonkBag -= coin.value;
				}
			}
			
			response = counter + "\n";
		}
		catch(Exception ex) {}
		
		return response;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
		
		try 
		{
			MonkAndPhilosopherStone problem = new MonkAndPhilosopherStone();
			bw.write( problem.solution() );
			bw.flush();
		}
		catch(Exception ex) {}
	}
}
