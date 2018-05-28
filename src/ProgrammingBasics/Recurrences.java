package ProgrammingBasics;

import java.io.*;

/*
# Examples of Recurrences.
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
 * This class represents the behavior of several Recurrences.
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Recurrences {

	/**
	 * 
	 * @param a
	 * @param b
	 * @return 
	 */
	public int mcd_euclides(int a, int b)
	{
		return 0;
	}
	
	
	/**
	 * 
	 * @param x
	 * @return 
	 */
	public int factorial(int x)
	{
		if(x > 1)
			return x * factorial(x - 1);
		else
			return 1;
	}
	
	
	/**
	 * 
	 * @param x
	 * @return 
	 */
	public int fibonacci(int x)
	{
		return 0;
	}
	
	

	/**
	 * 
	 * @param n
	 * @param k
	 * @return 
	 */
	public int pascal(int n, int k)
	{
		return 0;
	}
	
	
	/**
	 * 
	 * @return 
	 */
	public String print_pascal()
	{
		String pascal_matrix = "";
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j <= i; j++)
				pascal_matrix += pascal(i, j) + "\t";
			
			pascal_matrix += "\n";
		}
		
		return pascal_matrix;
	}
	
	
	/**
	 * 
	 * @param n
	 * @param x
	 * @return 
	 */
	public int multiplicacion(int n, int x)
	{
		return 0;
	}
	
	
	/**
	 * 
	 * @param cadena
	 * @return 
	 */
	public String inversa_cadena(String cadena)
	{
		if(cadena.length() == 1)
			return cadena;
		else
			return cadena.substring(cadena.length() - 1) + inversa_cadena(cadena.substring(0, cadena.length() - 1));
	}
		
	
	/**
	 * Describir en que consiste esta funcion
	 * @param cadena
	 * @return
	 */
	public boolean isPalindrome(String cadena)
	{
		return cadena.equals( inversa_cadena(cadena) ) ? true : false;
	}
	
	
	/**
	 * Describir en que consiste la funcion
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Recurrences recurrencias = new Recurrences();
	
		try
		{
			bw.write(recurrencias.factorial(15) + "\n"); // output: 2004310016
			
			bw.write(recurrencias.fibonacci(25) + "\n"); // output: 75025
			
			bw.write(recurrencias.multiplicacion(654, 97) + "\n"); // output: 63438
			
			bw.write(recurrencias.mcd_euclides(369, 1218) + "\n"); // output: 3
			
			bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); // output: lkjhgfdsa
			
			bw.write(recurrencias.print_pascal() + "\n");
			/*
			 * 1	
			 * 1	1	
			 * 1	2	1	
			 * 1	3	3	1	
			 * 1	4	6	4	1	
			 * 1	5	10	10	5	1	
			 * 1	6	15	20	15	6	1	
			 * 1	7	21	35	35	21	7	1	
			 * 1	8	28	56	70	56	28	8	1	
			 * 1	9	36	84	126	126	84	36	9	1
			 */
			
			bw.flush();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}