package Arrays_nD;

import processing.core.PApplet;

/*
# Arcade VideoGame: Bomberman
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
 * This class represents the behavior of Arcade VideoGame: Bomberman 
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BomberMan extends PApplet{
	
	/**
	 * 
	 *
	 */
	public class Logic
	{
		public int[][] board = new int[rows][columns];
		public int[] bomberman_position = new int[2];
		public boolean isThereBomb = false;
		int bombTimer = 0;
		
		public Logic()
		{
			init();
		}
		
		public void init()
		{
			//set weak walls
		}
		
		
		public void moveBomberman(String move)
		{
			if(move.equals("up"))
				if(bomberman_position[0] != 0)
					bomberman_position[0] -= 1;
			else
				if(move.equals("down"))
					if(bomberman_position[0] != rows - 1)
						bomberman_position[0] += 1;
				else
					if(move.equals("left"))
						if(bomberman_position[1] != 0)
							bomberman_position[1] -= 1;
					else
						if(move.equals("right"))
							if(bomberman_position[1] != columns - 1)
								bomberman_position[1] += 1;
		}
		
		public void fallBomb()
		{
			if(!this.isThereBomb)
			{
				bombTimer = 0;
				board[bomberman_position[0]][bomberman_position[1]] = 4;
			}
		}
	}
	
	
	public int width = 460, height = 400, size = 20;
	public int rows = height / size, columns = width / size;
	Logic logic_game = new Logic();
	
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
		background(250);
		stroke(200);
		
		//1:weak wall 2:heavy wall 3:ghost  4:bomb
		
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if(logic_game.board[i][j] == 1)
				{
					fill(150);
					rect(j * size, i * size, size, size);
				}
				else
				{
					if(logic_game.board[i][j] == 2)
					{	
						fill(100);
						rect(j * size, i * size, size, size);
					}
					else
					{
						if(logic_game.board[i][j] == 3)
						{
							fill(250,250,210);
							ellipse((j * size) + (size / 4), (i * size) + (size / 4), size, size);
						}
						else
						{
							if(logic_game.board[i][j] == 4)
							{
								fill(0);
								ellipse((j * size) + (size / 2), (i * size)  + (size / 2), (size / 2), (size / 2));
							}
						}
					}
				}
			}
		
		
		try
		{
			Thread.sleep(5);
		}
		catch(Exception ex) {}
	}
	
	public void keyPressed() 
	{
		if(key == 'w') //arriba
		{
			logic_game.moveBomberman("up");
		}
		else
		{
			if(key == 'w') //abajo
			{
				logic_game.moveBomberman("down");
			}
			else
			{
				if(key == 'w') //izquierda
				{
					logic_game.moveBomberman("left");
				}
				else
				{
					if(key == 'w') //derecha
					{
						logic_game.moveBomberman("right");
					}
					else
					{
						if(key == 'q') //bomba
						{
							logic_game.fallBomb();
						}
					}
				}
			}
		}
	}	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] appletArgs = new String[] {"Arrays_nD.Galaga"};
		PApplet.main(appletArgs);
	}
}
