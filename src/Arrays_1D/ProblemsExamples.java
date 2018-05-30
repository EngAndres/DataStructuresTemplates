package Arrays_1D;

/*
# Examples of Problems Solutions based on Arrays.
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
 * This class represents the behavior of several Problems Solutions based on Arrays
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class ProblemsExamples {
	
	
	/**
	 * Definition: Given an unsorted array and a number n, find if there exists a pair of elements 
	 * in the array whose difference is n. Return count of such pairs.
	 * @param array
	 * @param difference
	 * @return
	 */
	public static int countPairsOfNumbersWithAGivenDifference(int[] array, int difference)
	{
		int counter = 0;
		
		for(int i = 0; i < array.length; i++)
			for(int j = i + 1; j < array.length; j++)
				if((int)Math.abs(array[j] - array[i]) == difference)
					counter += 1;
		
		return counter;
	}
	
	
	/**
	 * Definition: Given an array of n integers where n>1, return an array of same size an input array where at 
	 * every index of the output array should contain the product of all elements in the array except the element
	 * at the given index.
	 * @param array
	 * @return
	 */
	public static int[] productOfAllOtherArrayNumbers(int[] array)
	{
		int[] response = new int[array.length];
		
		for(int i = 0; i < array.length; i++)
		{
			response[i] = 1;
			for(int j = 0; j < array.length; j++)
				if(i != j)
					response[i] *= array[j];
		}
		
		return response;
	}
	
	
	/**
	 * Definition: Given an array of integers, every element appears twice except for one. Find that single one.
	 * @param array
	 * @return
	 */
	public static int findANumberThatAppearsOnlyOnceInArrayOfDuplicates(int[] array)
	{
		int counter = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			counter = 0;
			for(int j = 0; j < array.length; j++)
				if(i != j && array[i] == array[j])
					counter += 1;
			
			if(counter == 0)
				return array[i];
		}
		return -1;
	}
	
	
	/**
	 * Definition: You have given a stock prices for next n days. Find out: max benefit in best time complexity in buy and sell 1 share?
	 * Condition: share must be sold and day after buying date.
	 * @param array
	 * @return
	 */
	public static int findBuySellPricesToMaximizeProfit(int[] array)
	{
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++)
			for(int j = i + 1; j < array.length; j++)
				if((array[j] - array[i]) > max)
					max = array[j] - array[i];
		
		return max;
	}
	
	
	/**
	 * Definition: Find the missing number in an Arithmetic Progression. An Arithmetic Progression is defined as one
	 * in which there is a constant difference between the consecutive terms of a given series of numbers.
	 * You are provided with consecutive elements of an Arithmetic Progression. There is however one hitch: exactly one
	 * number from the original series is missing from the set of numbers which have been given to you.
	 * The rest of the given series is the same as the original AP. Find the missing number.
	 * @param array
	 * @return
	 */
	public static int findTheMissingElementInArithmeticProgression(int[] array)
	{
		int min = Integer.MAX_VALUE, lost_number = 0;
		
		for(int i = 0; i < array.length; i++)
			for(int j = i + 1; j < array.length; j++)
				if((array[j] - array[i]) < min)
					min = array[j] - array[i];
		
		for(int i = 0; i < array.length; i++)
			if((array[i + 1] - array[i]) != min)
			{
				lost_number = array[i] + min;
				break;
			}
		
		if(lost_number == 0)
			lost_number = array[array.length - 1] + min;
		
		return lost_number;
	}
}