package Arrays_1D;

import java.io.*;
import java.util.Random;

/*
# Examples of Sort Algorithms based on arrays.
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
 * This class represents the behavior of several Sort Algorithms based on arrays
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class SortAlgorithms {
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public void insertionSort(int[] unsortedArray)
	{
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public void selectionSort(int[] unsortedArray)
	{
		int indexSmallest, tempSwap;
		
		for(int i = 0; i < unsortedArray.length - 1; i++)
		{
			indexSmallest = i;
			
			for(int j = i + 1; j < unsortedArray.length; j++)
				if(unsortedArray[j] < unsortedArray[indexSmallest])
					indexSmallest = j;
			
			tempSwap = unsortedArray[i];
			unsortedArray[i] = unsortedArray[indexSmallest];
			unsortedArray[indexSmallest] = tempSwap;
		}
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public void bubbleSort(int[] unsortedArray)
	{
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 */
	public void countingSort(int[] unsortedArray)
	{
		int max = Integer.MIN_VALUE;
		int index = 0;
		int[] aux;
		
		for(int i = 0; i < unsortedArray.length; i++)
			if(unsortedArray[i] > max)
				max = unsortedArray[i];
		
		aux = new int[max + 1];
		
		for(int i = 0; i < unsortedArray.length; i++)
			aux[ unsortedArray[i] ] += 1;
		
		
		for(int i = 0; i <= max; i++)
			for(int j = 0; j < aux[i]; j++)
			{
				unsortedArray[index] = i;
				index += 1;
			}
	}
	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public int[] mergeSort(int[] unsortedArray)
	{
		if(unsortedArray.length > 1) //Condition to end recursive: If array is of size equal to 1, no more calls are necessary
		{
			int n = unsortedArray.length / 2; 
			int[] array_left = new int[n]; //Create array of the left side
			int[] array_right = new int[unsortedArray.length - n]; //Create array of the right side 
			
			for(int i = 0; i < n; i++) //Copy first half of the array inside left array
				array_left[i] = unsortedArray[i]; //Copy data
			
			for(int i = 0; i < array_right.length; i++) //Copy second half of the array inside right array
				array_right[i] = unsortedArray[n + i]; //Copy data
			
			array_left = mergeSort(array_left); //Call recursive to order array of left size
			array_right = mergeSort(array_right); //Call recursive to order array of left size
			
			return merge(array_left, array_right); //Merge order arrays of both left and right size
		}
		else
		{
			return unsortedArray; //Return array if his size is 1 
		}
	}
	
	
	/**
	 * 
	 * @param array_left
	 * @param array_right
	 * @return
	 */
	public int[] merge(int[] array_left, int[] array_right)
	{
		int[]temp = new int[array_left.length + array_right.length]; //Create array of complete size, i.e. size of left array plus size of right array
		int left = 0, right = 0, index = 0; //Index for: left array, right array, and temp array. All must start in zero.
		
		while(left < array_left.length && right < array_right.length) //While are still elements inside left array or right array, we can made comparisons
		{
			if(array_left[left] <= array_right[right]) //If element in left array is minor or equal to element in right array
			{
				temp[index] = array_left[left]; //Add element of left array
				left += 1; //Because we add an element of left array, index that control left array must increase
			}
			else
			{
				temp[index] = array_right[right]; //Add element of right array
				right += 1; //Because we add an element of right array, index that control right array must increase
			}
			
			index += 1; //Increase index of complete array
		}
		
		if(left < array_left.length) //If there are still element in left array
			for(int i = left; i < array_left.length; i++) //Add all elements of left array
			{
				temp[index] = array_left[left]; //Add element
				left += 1; //Increase index over left array
				index += 1; //Increase index over complete array
			}	
		else //If there are still element in left array
			for(int i = right; i < array_right.length; i++) //Add all elements of right array
			{
				temp[index] = array_right[right]; //Add element
				right += 1; //Increase index over right array
				index += 1;  //Increase index over complete array
			}	
		
		return temp; //Return complete array 
	}
	
	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public int[] quickSort(int[] unsortedArray)
	{
		return null;
	}

	
	/**
	 * 
	 * @param unsortedArray
	 * @return
	 */
	public int[] randomQsuickSort(int[] unsortedArray)
	{

		return null;
	}
	
	
	/**
	 * 
	 * @param pathFile
	 * @return
	 */
	public int[] readArrayFromFile(String pathFile)
	{
		try
		{
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader( fr );
			
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			br.close();
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int[] readArrayFronConsole()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		try
		{
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		SortAlgorithms sorts = new SortAlgorithms();
		BasicOperations bo = new BasicOperations();
		
		int[] a = sorts.readArrayFronConsole();
		a = sorts.mergeSort(a);
		bo.printArray(a);
	}
}