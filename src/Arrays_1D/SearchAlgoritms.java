package Arrays_1D;

/*
# Examples of Search Algorithms based on arrays.
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
 * This class represents the behavior of several Search Algorithms based on arrays
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class SearchAlgoritms {
	
	
	/**
	 * 
	 * @param arrayData
	 * @param value
	 * @return
	 */
	public int linealSearch(int[] arrayData, int value)
	{
		int index = -1;
		
		for(int i = 0; i < arrayData.length; i++)
			if(arrayData[i] == value)
			{
				index = i;
				break;
			}
		
		return index;
	}
	
	
	/**
	 * 
	 * @param arrayData
	 * @param value
	 * @return
	 */
	public int binarySearch(int[] arrayData, int value)
	{
		return -1;
	}
	
	
	/**
	 * 
	 * @param arrayData
	 * @param value
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public int binarySearch_recursive(int[] arrayData, int value, int lowerBound, int upperBound)
	{
		int middlePoint = (lowerBound + upperBound) / 2;
		
		if(lowerBound == upperBound)
			if(value == arrayData[middlePoint])
				return middlePoint;
			else
				return -1;
		else
			if(value == arrayData[middlePoint])
				return middlePoint;
			else
				if(value < arrayData[middlePoint])
					return binarySearch_recursive(arrayData, value, lowerBound, middlePoint);
				else
					return binarySearch_recursive(arrayData, value, middlePoint + 1, upperBound);
			
	}

	
	/**
	 * 
	 * @param arrayData
	 * @param value
	 * @return
	 */
	public int interpolationSearch(int[] arrayData, int value)
	{
		int lowerBound = 0;
		int upperBound = arrayData.length - 1;
		int index = -1, middlePoint;
		
		while(lowerBound < upperBound)
		{
			middlePoint = lowerBound + ((upperBound - lowerBound) / (arrayData[upperBound] - arrayData[upperBound])) * (value - arrayData[lowerBound]);
			
			if(middlePoint < lowerBound || middlePoint > upperBound)
				break;
				
			if(value == arrayData[middlePoint])
			{
				index = middlePoint;
				break;
			}
			else
			{
				if(value < arrayData[middlePoint])
					upperBound = middlePoint - 1;
				else
					lowerBound = middlePoint + 1;
			}
		}
		
		if(lowerBound == upperBound && arrayData[lowerBound] == value)
			index = lowerBound;
		
		return index;
	}
	
	
	/**
	 * 
	 * @param arrayData
	 * @param value
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public int interpolationSearch_recursive(int[] arrayData, int value, int lowerBound, int upperBound)
	{
		return -1;
		
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int value = 110;
		int[] array = {4,3,6,8,9,32,4,76,98,5};
		SortAlgorithms sorts = new SortAlgorithms();
		sorts.insertionSort( array );
		
		SearchAlgoritms searchs = new SearchAlgoritms();
		System.out.println( searchs.interpolationSearch_recursive(array, value,0,array.length - 1) );
	}
}