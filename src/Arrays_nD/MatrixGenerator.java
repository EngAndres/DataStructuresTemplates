package Arrays_nD;

/*
# Generate a nxn random binary matrix.
#
# Created by Msc. Carlos Andres Sierra on June 2017.
# Copyright (c) 2017  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructures course.
#
# DataStructuresCourse is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 2.
*/


/**
 * This class represents the behavior of a nxn random binary matrix
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class MatrixGenerator {
	
	
	/**
	 * Zero-parameter class constructor
	 */
	public MatrixGenerator(){}
	
	
	/**
	 * This method generates the matrix that will be shown in the applet
	 * @param length
	 * @return binary matrix
	 */
	public int[][] generate(int length)
	{
		//Create a square matrix based on the "length" parameter
		int[][] matrix = new int[length][length];
		
		//Move througth all the matrix
		for(int i = 0; i < length; i++)
			for(int j = 0; j < length; j++)
				//Use a Bernoulli Distribution to generate a random binary matrix
				matrix[i][j] = Math.random() < 0.5 ? 0 : 1;
		
		return matrix;
	}
}