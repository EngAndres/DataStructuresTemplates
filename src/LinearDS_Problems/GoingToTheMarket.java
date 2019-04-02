package LinearDS_Problems;
//https://www.urionlinejudge.com.br/judge/en/problems/view/1281

import LinearDataStructures.List;
import LinearDataStructures.Node;
import java.io.*;
import java.text.DecimalFormat;


public class GoingToTheMarket {

		public class Product implements Node
		{
			public String name = "";
			public double price = 0.0;
			public Product next = null;
			
			public Product(String name_, double price_)
			{
				this.name = name_;
				this.price = price_;
			}
			
			@Override
			public void setNext(Node node) 
			{
				this.next = (Product)node;
			}

			@Override
			public Node getNext() 
			{
				return this.next;
			}

			@Override
			public Node clone() 
			{
				return new Product(name, price);
			}

			@Override
			public boolean isEqual(Node node) 
			{
				Product temp = (Product)node;
				return this.name.equals( temp.name ) ? true : false;
			}

			@Override
			public boolean isLessThan(Node node) {
				// TODO Auto-generated method stub
				return false;
			}
			
		}
		
		public GoingToTheMarket() {}
		
		public String solution()
		{
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
			DecimalFormat df = new DecimalFormat("0.00");
			
			List products = new List();
			double total_price = 0.0;
			
			try
			{
				String[] temp;
				int m = Integer.parseInt( br.readLine() );
				
				for(int i = 0; i < m; i++)
				{
					temp = br.readLine().split(" ");
					products.insertAtEnd(new Product(temp[0], Double.parseDouble(temp[1])));
				}
				
				int p = Integer.parseInt( br.readLine() );
				for(int i = 0; i < p; i++)
				{
					temp = br.readLine().split(" ");
					Product temp_node = (Product)products.linealSearch(new Product(temp[0], 0.0));
					total_price += temp_node.price * Integer.parseInt( temp[1] ); 
				}
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
				
			return "R$ " + df.format(total_price) + "\n";
		}
		
		public static void main(String[] args)
		{
			BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));
			GoingToTheMarket problem = new GoingToTheMarket();
			
			try
			{
				int n = Integer.parseInt( br.readLine() );
				
				for(int i = 0; i < n; i++)
				{
					bw.write( problem.solution() );
				}
				
				bw.flush();
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
}
