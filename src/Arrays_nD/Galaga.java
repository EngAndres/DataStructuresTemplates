package Arrays_nD;

import processing.core.PApplet;

public class Galaga extends PApplet {

	public class Logic
	{
		private int width_ = 23, height_ = 20;
		private int movement = 1, dx = 1, iterationsChange = 0;
		private int spacechip = (int)(width_ / 2);
		
		public int[][] board = new int[height_][width_];
		
		public Logic()
		{
			init();
		}
		
		public void init()
		{
			//colocar moscas espaciales
			for(int j = 1; j < width_; j += 2)
				board[1][j] = 1;
			
			for(int j = 2; j < width_ - 1; j 	+= 2)
				board[2][j] = 1;
			
			for(int j = 3; j < width_ - 2; j += 2)
				board[3][j] = 1;
			
			board[height_ - 2][spacechip] = 2;
		}
		
		
		public void moveFlies()
		{
			if(iterationsChange == 80)
			{
				if(movement == 2)
					dx = -1;
				else
					if(movement == 0)
						dx = 1;
				
				if(dx == -1)
				{
					for(int i = 1; i < 4; i++)
						for(int j = 0; j < width_ - 1; j++)
							board[i][j] = board[i][j + 1];
					
					for(int i = 1; i < 4; i++)
						board[i][width_ - 1] = 0;
					
				}
				else
				{
					for(int i = 1; i < 4; i++)
						for(int j = width_ - 1; j > 0; j--)
							board[i][j] = board[i][j - 1];
					
					for(int i = 1; i < 4; i++)
						board[i][0] = 0;
				}
				
				movement += dx;
				iterationsChange = 0;
			}
			else
				iterationsChange += 1;
			
			for(int i = 1; i < height_ - 2; i++)
				for(int j = 0; j < width_; j++)
					if(board[i][j] == 3)
					{
						board[i][j] = 0;
						
						if(i <= 4)
							if(board[i - 1][j] == 1)
								board[i - 1][j] = 4;
							else
								board[i - 1][j] = 3;
						else
							board[i - 1][j] = 3;
					}
					else
						if(board[i][j] == 4)
							board[i][j] = 0;
			
			for(int j = 0; j < width_; j++)
				board[0][j] = 0;
		}
		
		public void move_spaceship(int move)
		{
			if(spacechip <= 0 && move == -1)
				System.out.println("No valid!");
			else
				if((spacechip >= (width_ - 1)) && move == 1)
					System.out.println("No valid!");
				else
				{
					board[height_ - 2][spacechip] = 0;
					spacechip += move;
					board[height_ - 2][spacechip] = 2;
				}
		}
		
		public void shoot()
		{
			board[height_ - 3][spacechip] = 3; 
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
		background(0,0,30);
		stroke(20);
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				if(logic_game.board[i][j] == 1)
				{
					fill(200,10,10);
					triangle(j * size, i * size, (j * size) + size, i * size, (j * size) + (size / 2), (i * size) + size);
				}
				else
				{
					if(logic_game.board[i][j] == 2)
					{	
						fill(255);
						triangle(j * size, (i * size) + size, (j * size) + size, (i * size) + size, (j * size) + (size / 2), (i * size));
					}
					else
					{
						if(logic_game.board[i][j] == 3)
						{
							fill(255);
							ellipse((j * size) + (size / 2), (i * size)  + (size / 2), (size / 2), (size / 2));
						}
						else
						{
							if(logic_game.board[i][j] == 4)
							{
								fill(255,150,150);
								ellipse((j * size) + (size / 4), (i * size) + (size / 4), size, size);
							}
						}
					}
				}
			}
		
		logic_game.moveFlies();
		
		try
		{
			Thread.sleep(5);
		}
		catch(Exception ex) {}
	}
	
	public void keyPressed() 
	{
		if(key == 'a')
			logic_game.move_spaceship(-1);
		else
			if(key == 'd')
				logic_game.move_spaceship(1);
			else
				if(key == 'x')
					logic_game.shoot();
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