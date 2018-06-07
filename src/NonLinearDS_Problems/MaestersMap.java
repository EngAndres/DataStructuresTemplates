package NonLinearDS_Problems;

import java.io.*;

/*
# Contest Problem: Maesters Map
# https://www.urionlinejudge.com.br/judge/en/problems/view/1855
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
 * This class represents the solution of Contest Problem: Maesters Map
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class MaestersMap {

	public static void main(String[] args) 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));

		int height, width;
		try 
		{
			width = Integer.parseInt( br.readLine() );
			height = Integer.parseInt( br.readLine() );
			
			char[][] map = new char[height][width];
			
			String temp;
			
			for(int i = 0; i < height; i++)
			{
				temp = br.readLine();
				
				for(int j = 0; j < width; j++)
					map[i][j] = temp.charAt(j);
			}
			
			int x = 0, y = 0, dx = 0, dy = 0;
			
			while(x < width && y < height && x > -1 && y > -1)
			{
				if(map[y][x] == '-')
					break;
				
				if(map[y][x] == '>')
				{
					dx = 1;
					dy = 0;
					map[y][x] = '-';
				}
				else
				{
					if(map[y][x] == '<')
					{
						dx = -1;
						dy = 0;
						map[y][x] = '-';
					}
					else
					{
						if(map[y][x] == '^')
						{
							dx = 0;
							dy = -1;
							map[y][x] = '-';
						}
						else
						{
							if(map[y][x] == 'v')
							{
								dx = 0;
								dy = 1;
								map[y][x] = '-';
							}
							else
							{
								if(map[y][x] == '*')
								{
									bw.write("*\n");
									break;
								}
							}
						}
					}
				}
				
				x += dx;
				y += dy;
			}
			
			
			if( x == width || x == -1 || y == height || y == -1)
				bw.write("!\n");
			else
				if(map[y][x] == '-')
					bw.write("!\n");
			
			bw.flush();
		} 
		catch (Exception ex) {} 
	}
}
