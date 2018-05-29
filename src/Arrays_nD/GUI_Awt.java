package Arrays_nD;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/*
# GUI for Matrix  made in AWT Library.
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
public class GUI_Awt extends JApplet {
	
	//Default serial
	private static final long serialVersionUID = 1L;
	
	
	private int ca_lenght = 400; //Cellular automata' length
	private int screen_size = 800; //Size of the frame on the screen
	private int delay_time = 1; //Delay time of each screen change
	
	
	/**
	 * This method defines the setup of the ppplet
	 */
	public void init() 
    {
        setSize(screen_size, screen_size); //Define applet' screen size
		setBackground(Color.white); //Define background color
    }
 	
	
	/**
	 * This method represents the process of paint the cellular automata
	 */
    public void paint(Graphics g) 
    {
        //Create the object that will draw all the squares
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        //Coordinates of the initial square of the cellular automata
        int x = 0;
        int y = 0;
        
        //Size of each square
        int square_size = screen_size / ca_lenght;
 
        //Create the object that generate the matrix 
        MatrixGenerator cellular_automata = new MatrixGenerator();
        
        //While the application was opened
        while(true)
        {
        	int[][] matrix = cellular_automata.generate(ca_lenght); //Generate a new cellular automata matrix
        	
        	y = 0; //Starts on the top side origin
        	
        	//Move throught all the cellular automata
        	for(int i = 0; i < ca_lenght; i++)
        	{
        		//Starts on the left side origin
        		x = 0;
        		for(int j = 0; j < ca_lenght; j++)
        		{
        			//If the postion in the matrix is zero, paint the square of blue color
	    		   if(matrix[i][j] == 0)
	    		   {
	    			   g2.setPaint(Color.blue);
	    		   }
	    		   else  //The postion in the matrix is one, paint the square of green color
	    		   {
	    			   g2.setPaint(Color.green);
	    		   }
    		   
	    		   //Paint the square in each position coordinate
	    		   g2.fill(new Rectangle2D.Double(x, y, square_size, square_size));
	    		   
	    		   x += square_size; //Move to the next coordinate in horizontal sense
	    		}
        		
        		y += square_size; //Move to the next coordinate in vertical sense
        	}
       
        	//Delay of each change time in every screen drawn
        	try 
        	{
        		Thread.sleep( delay_time );
        	} 
        	catch (InterruptedException e) 
        	{
        		e.printStackTrace();
        	}
       
       }
    }
 
    
    /**
     * This is the main method of the class. Here is where all the application starts.
     */
    public static void main(String args[])
    {
        //Create a frame for the simulation
    	JFrame frame = new JFrame("CellularAutomata");

    	//Add a listener to the frame
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        //Create the applet that will show the simulation
        JApplet applet = new GUI_Awt();
        
        //Add the applet to the frame
        frame.getContentPane().add("Center", applet);
        
        //Initialize the applet and run the simulation
        applet.init();
        
        //Add properties to the frame
        frame.pack();
        frame.setSize(new Dimension(800,800));
        frame.setVisible(true);
    }
}