package Arrays_nD;

/*
# Fractals based on Chaos Rules (62, 90, 115, 102, ...).
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
 * This class represents the behavior of Fractals based on Chaos Rules 
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class ChaosFromFractal {

	/*
	 * 
	 */
	int[] chaos_rule = null;
	int[][] matrix = null;
	int rows, columns;
	
	/**
	 * 
	 * @param number
	 * @param rows
	 * @param columns
	 */
	public ChaosFromFractal(int number, int rows, int columns)
	{
		this.chaos_rule = new int[8];
		this.matrix = new int[rows][columns];
		this.rows = rows;
		this.columns = columns;
		
		convert_dec2bin(number);
		
		//for(int j = 0; j < columns; j++)
			//this.matrix[0][j] = Math.random() < 0.5 ? 0 : 1;
	
		this.matrix[0][(int)(columns / 2)] = 1;
		
		first_iteration();
	}
	
	
	/**
	 * 
	 * @param decimal_number
	 */
	private void convert_dec2bin(int decimal_number)
	{
		int temp = decimal_number;
		String binary_number = "";
		
		while(temp >= 2)
		{
			binary_number += temp % 2;
			temp /= 2;
		}
		
		binary_number += 1;
		
		for(int i = 0; i < binary_number.length(); i++)
			chaos_rule[i] = Integer.parseInt( binary_number.substring(i, i + 1) );
	}
	
	
	/**
	 * 
	 */
	private void first_iteration()
	{
		int index = -1;
		
		for(int i = 1; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				index = (matrix[i - 1][(j - 1 + columns) % columns] * 4) + (matrix[i - 1][j] * 2) + (matrix[i - 1][(j + 1) % columns] * 1);
				matrix[i][j] = chaos_rule[index];
			}
	}
	
	
	/**
	 * 
	 */
	public void iterations()
	{
		
	}
}