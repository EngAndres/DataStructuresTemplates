package MotifSearch;

import java.io.*;

import LinearDataStructures.List;

/*
# Search a motif in a list of experimental DNA sequences.
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
 * This class represents the behavior of search motifs in a sequences data set
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class SearchMotif {
	
	List sequencesList = new List(); //
	int max_occurrences = Integer.MIN_VALUE; //
	String motif_winner = ""; //
	
	
	/**
	 * 
	 * @param motif_candidate
	 */
	public void compareMotif(String motif_candidate)
	{
		int counter = counterOccurrences(motif_candidate);
		if(counter > max_occurrences)
		{
			max_occurrences = counter;
			motif_winner = motif_candidate;
		}
	}
	
	
	/**
	 * 
	 * @param motif_candidate
	 * @return
	 */
	public int counterOccurrences(String motif_candidate)
	{
		int counter = 0;
		String gen_sequence;
		
		Sequence temp = (Sequence) sequencesList.head;
		while(temp != null)
		{
			gen_sequence = temp.sequence;
			
			for(int i = 0; i <= (gen_sequence.length() - motif_candidate.length()); i++)
				if(gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate))
				{
					counter += 1;
					i += motif_candidate.length() - 1;
				}
			
			temp = (Sequence)temp.getNext();
		}
		
		return counter;
	}
	
	
	/**
	 * 
	 * @param subsequence
	 * @param size
	 */
	public void generateCombinations(String subsequence, int size)
	{
		if(size == 1)
		{
			compareMotif(subsequence + "A");
			compareMotif(subsequence + "C");
			compareMotif(subsequence + "G");
			compareMotif(subsequence + "T");
		}
		else
		{
			generateCombinations(subsequence + "A", size - 1);
			generateCombinations(subsequence + "C", size - 1);
			generateCombinations(subsequence + "G", size - 1);
			generateCombinations(subsequence + "T", size - 1);
		}
	}
	
	
	/**
	 * 
	 */
	public void countChromosomes() 
	{
		
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			FileReader fr = new FileReader("sequences.txt");
			BufferedReader br = new BufferedReader( fr );
			
			String input = br.readLine();
			SearchMotif run = new SearchMotif();
			
			while(input != null)
			{
				String[] data = input.split(",");
				run.sequencesList.insertAtEnd(new Sequence(data[0], data[1], 
						Integer.parseInt(data[2]), Integer.parseInt(data[3])));
				
				input = br.readLine();
			}
			
			run.generateCombinations("", 4);
			System.out.println("Motif ganador:" + run.motif_winner + "\tOcurrencias: " + run.max_occurrences);
			
			run.countChromosomes();
		}
		catch(Exception ex) {}
	}
}