package Arrays_nD;

public class GameOfLife {
	
	public int rows, columns;
	public double aliveRate;
	public int[][] board = null;
	
	public GameOfLife(int rows, int columns, double aliveRate)
	{
		this.rows = rows;
		this.columns = columns;
		this.aliveRate = aliveRate;
		
		this.board = new int[rows][columns];
		this.randomInit();
	}
	

	public void randomInit()
	{
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
				this.board[i][j] = Math.random() < aliveRate ? 1 : 0;
	}
	
	
	public int countNeighborsToroidal(int i, int j)
	{
		return 0;
	}	
	
	
	public int countNeighbors(int i, int j)
	{
		return 0;
	}
	
	
	
	public void iterations()
	{
		int[][] next_generation = this.board.clone();
		int counter;
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < columns; j++)
			{
				
			}
		
		board = next_generation.clone();
	}
}