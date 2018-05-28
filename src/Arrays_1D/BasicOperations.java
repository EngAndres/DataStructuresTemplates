package Arrays_1D;

import java.io.*;

/*
# Examples of Basic Operations on arrays.
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
 * This class represents the behavior of several basic operations on arrays
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BasicOperations {

	
	/**
	 * 
	 * @param array
	 */
	public void printArray(int[] array)
	{
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		try
		{
			for(int i = 0; i < array.length - 1; i++)
				bw.write(array[i] + ",");
			
			bw.write(array[array.length - 1] + "\n");
			bw.flush();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int sum(int[] array)
	{
		int acum = 0;
		
		for(int i = 0; i < array.length; i++)
			acum += array[i];
		
		return acum;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public double average(int[] array)
	{
		return sum(array) / (double)array.length;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int min(int[] array)
	{
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] < min)
				min = array[i];
			
		return min;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int max(int[] array)
	{
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] > max)
				max = array[i];
			
		return max;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int indexOf(int[] array, int value)
	{
		int index = -1;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] == value)
			{
				index = i;
				break;
			}
		
		return index;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int occurrencesOf(int[] array, int value)
	{
		int counter = 0;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] == value)
				counter += 1;
		
		return counter; 
	}
	
	
	/**
	 * 
	 * @param array
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public int[] subarray(int[] array, int beginIndex, int endIndex)
	{
		int[] sub = null;
		
		if(beginIndex < endIndex && endIndex < array.length)
		{
			sub = new int[endIndex - beginIndex];
			for(int i = 0; i < (endIndex - beginIndex); i++)
				sub[i] = array[beginIndex + i];
		}
		
			
		return sub;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param oldNumber
	 * @param newNumber
	 */
	public void replace(int[] array, int oldNumber, int newNumber)
	{
		for(int i = 0; i < array.length; i++)
			if(array[i] == oldNumber)
				array[i] = newNumber;
	}
}