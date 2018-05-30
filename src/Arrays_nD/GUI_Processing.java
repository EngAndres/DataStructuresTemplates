package Arrays_nD;

import processing.core.PApplet;

/*
# GUI for Matrix  made in Processing API.
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
 * This class represents the behavior of a GUI made in Processing API
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class GUI_Processing extends PApplet {

	/*
	 * 
	 */
	public int width = 900, height = 600, size = 10, rule = 90;
	public int rows = height / size, columns = width / size;
	//ChaosFromFractal chaos = new ChaosFromFractal(rule, rows, columns);
	GameOfLife life = new GameOfLife(rows, columns, 0.08);
	
	/**
	 * 
	 */
	public void settings()
	{
		size(width, height);
	}
		
	
	/**
	 * 
	 */
	public void draw()
	{
		background(0);
		stroke(20);
		
		/* For chaos 
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if(chaos.matrix[i][j] == 0)
					fill(0);
				else
					fill(255);
				
				rect(j * size, i * size, size, size);
			}
				
		chaos.iterations();
		*/ 
		
		//For Game of Life
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				if(life.board[i][j] == 0)
					fill(0);
				else
					fill(255);
				
				rect(j * size, i * size, size, size);
			}
		}
		
		life.iterations();
		
		try
		{
			Thread.sleep(100);
		}
		catch(Exception ex) {}
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] appletArgs = new String[] {"Arrays_nD.GUI_Processing"};
		PApplet.main(appletArgs);
	}
}