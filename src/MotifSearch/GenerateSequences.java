package MotifSearch;

import java.io.*;
import java.util.Random;


/*
# Generate in-silico experimental DNA sequences.
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
 * This class represents the behavior of in-silico experimental DNA sequences generation
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class GenerateSequences {

	/**
	 * 
	 * @return
	 */
	public static String chromosome()
	{
		Random rd = new Random();
		return "chr" + (rd.nextInt(23) + 1);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static String nucleotide()
	{
		Random rd = new Random();
		switch(rd.nextInt(4))
		{
			case 0: 	return "A";	
			case 1:		return "C";	
			case 2:		return "G";	
			case 3:		return "T";
			default:  	return "";
		}
	}
	
	
	/**
	 * 
	 * @param length
	 * @return
	 */
	public static String sequence(int length)
	{
		return "";
	}
	
	
	/**
	 * 
	 */
	public static void saveSequences()
	{
		try 
		{
			FileWriter file = new FileWriter("sequences.txt");
			BufferedWriter bw = new BufferedWriter(file);
			Random rd = new Random();
			int length, start, datasize = 100;
			String experimental_read;
			
			for(int i = 0; i < datasize; i++)
			{
				length = rd.nextInt(46) + 5;
				start = rd.nextInt(1000 + 1);
				experimental_read = sequence(length) + "," + chromosome() +	"," + start  + "," + (start + length - 1);
				bw.write(experimental_read + "\n");
			}
			
			bw.flush();
			bw.close();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		saveSequences();
	}
}