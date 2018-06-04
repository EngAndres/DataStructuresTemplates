package LinearDS_Problems;

import java.io.*;

import LinearDataStructures.Queue;
import LinearDataStructures.Node;


/*
# Contest Problem: Monk And Chamber Of Secrets
# https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/monk-and-chamber-of-secrets/
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
 * This class represents the solution of Contest Problem: Monk And Chamber Of Secrets
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class MonkAndChamberOfSecrets {
	/**
	 * 
	 *
	 */
	public class ProblemNode implements Node
	{
		public int index;
		public int value;
		public ProblemNode next = null;
		
		/**
		 * 
		 * @param value
		 */
		public ProblemNode(int value, int index) 
		{
			this.value = value;
			this.index = index;
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
			ProblemNode temp = new ProblemNode(this.value, this.index);
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
			return this.index + " ";
		}
	}
	
	/**
	 * 
	 */
	public MonkAndChamberOfSecrets() {}
	
	
	/**
	 * 
	 * @return
	 */
	public String solution() 
	{
		String response = "";
				
		try
		{
			int spidersQueue = 0, spidersToSelect = 0, counter = 0, max;
			
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
			String[] input = br.readLine().split(" ");
			
			spidersQueue = Integer.parseInt( input[0] );
			spidersToSelect = Integer.parseInt( input[1] );
			
			ProblemNode spider = null;
			Queue spiders = new Queue();
			Queue selected = new Queue();
			Queue temp;
			
			input = br.readLine().split(" ");
			
			for(int i = 0; i < spidersQueue; i++)
				spiders.enqueue(new ProblemNode( Integer.parseInt(input[i]) , (i + 1) ));

			for(int i = 0; i < spidersToSelect; i++)
			{
				counter = 0;
				temp = new Queue();
				max = Integer.MIN_VALUE;
				
				while(counter < spidersToSelect && !spiders.isEmpty())
				{
					spider = (ProblemNode)spiders.dequeue();
					
					if(max < spider.value)
						max = spider.value;
					
					temp.enqueue( spider );
					counter++;
				}
				
				while(!temp.isEmpty())
				{
					spider = (ProblemNode)temp.dequeue();
					
					if(spider.value ==  max)
					{
						selected.enqueue(spider);
						max = -1;
					}
					else
					{
						if(spider.value > 0)
							spider.value -= 1;
						
						spiders.enqueue( spider );
					}
				}
			}
			
			while(!selected.isEmpty())
				response += selected.dequeue().toString();
			
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
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
			MonkAndChamberOfSecrets problem = new MonkAndChamberOfSecrets();
			bw.write( problem.solution() + "\n" );
			bw.flush();
		}
		catch(Exception ex) {}
	}
}
