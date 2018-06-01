package Strings;

import java.io.*;


/*
# Examples of Problems Solutions based on Strings.
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
 * This class represents the behavior of several Problems Solutions based on Strings
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class ProblemsExamples {

	
	/**
	 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/its-confidential-f006e2c4/
	 * @param input
	 * @return
	 */
	public static String itsConfidencial(String input)
	{
		if(input.length() > 1)
		{
			int middle = (int)(Math.ceil(input.length() / 2.0) - 1);
			return input.substring(middle, middle + 1) 
					+ itsConfidencial(input.substring(0, middle)) 
					+ itsConfidencial(input.substring(middle + 1));
		}
		else
			return input;
	}
	
	
	/**
	 * https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/dna-pride/
	 * @param length
	 * @param input
	 * @return
	 */
	public static String dna_pride(int length, String input)
	{
		String output = "";
		if(!input.contains("U"))
			for(int i = 0; i < length; i++)
				switch(input.charAt(i))
				{
					case 'A':	output += "T";	break;
					case 'C':	output += "G";	break;
					case 'G':	output += "C";	break;
					default:	output += "A";	break;
				}
		else
			output = "Error RNA nucleobases found!";
		
		return output;
	}
	
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static int bin2dec(String input)
	{
		int number = 0;
		int length = input.length();
		for(int i = 0; i  < input.length(); i++)
		{
			
			int index = length - 1 - i;
			number += ((Integer.parseInt(input.substring(index, index + 1)) * (int)(Math.pow(2, i)))) % 1000000000;
		} 
		
		return number;
	}
	
	
	/**
	 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/gcd-strings/
	 * @param a
	 * @param b
	 * @return
	 */
	public static String gcd_string(int a, int b)
	{
		String number_binary = "";
		
		if(a % b == 0)
		{
			number_binary = "1";
			for(int i = 0; i < a - 1; i++)
				number_binary += "0";
		}	
		else
		{
			String pattern = gcd_string(b, (a % b));
			while(number_binary.length() < a)
				number_binary += pattern;
			
			number_binary = number_binary.substring(0, a);
		}
		return number_binary;
	}
	
	
	/**
	 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/
	 * @param a
	 * @param b
	 * @return
	 */
	public static int anagrams(String a, String b)
	{
		int counter = 0, i, j;
		boolean found;
		
		for(i = 0; i < a.length(); i++)
		{
			found = false;
			
			for(j = 0; j < b.length(); j++)
				if(a.charAt(i) == b.charAt(j)) 
				{
					found = true;
					break;
				}
			
			if(!found)
				counter += 1;
			else
				b = b.substring(0, j) + b.substring(j + 1);
		}
		
		return counter;
	}
	
	
	/**
	 * https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/palindrome-check-2/
	 * @param input
	 * @return
	 */
	public static String palindromic_string(String input)
	{
		boolean response = true;
		int size = input.length();
		int middle = size / 2;
		
		for(int i = 0; i < middle; i++)
			if(input.charAt(i) != input.charAt(size - 1 - i))
			{
				response = false;
				break;
			}
		
		if(response)
			return "YES\n";
		else
			return "NO\n";
	}
	
	
	/**
	 * https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/print-first-occurence/
	 * @param input
	 * @return
	 */
	public static String print_first_occurence(String input)
	{
		String response = "";
		boolean found;
		
		for(int i = 0; i < input.length(); i++)
		{
			found = false;
			
			for(int j = 0; j < response.length(); j++)
				if(input.charAt(i) == response.charAt(j)) 
				{
					found = true;
					break;
				}
			
			if(!found)
				response += input.substring(i, i + 1);
		}
		
		return response;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			int cases = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < cases; i++)
				bw.write( (palindromic_string( br.readLine() )));
				
			bw.flush();
		}
		catch(Exception ex) {}
	}
}