/*********************************************************************************************************************
     **
     **  Floyd Warshell Algorothm
     **  Use to find shortest path in +ve and -ve edges
     **  Input in the form of array
     **  Output is printed as shortest path of each vertex 
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.io.*;
import java.util.*;

class Main
{

    //matrix to store path
	static int [][]path;
	static int n;
	
	public static void printPath(int i,int j)
	{
		if (path[i][j]==i)
			return;

		printPath(i, path[i][j]);
		System.out.print(path[i][j] + " ");
	}

	public static void printSolution()
	{
		for (int i=0;i<n;i++)
		{
			for (int j=0; j<n;j++)
			{
				if (i!=j && path[i][j]!=-1)
				{
					System.out.print("Shortest Path from " + i +
							" to " + i + " : (" + i + " ");
					printPath(i,j);
					System.out.println(j + ")");
				}
			}
		}
	}

	public static void floydWarshell(int[][]a)
	{

        //initialization path matrix
		for (int i = 0; i< n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i==j)
					path[i][j] = 0;
				else if (a[i][j]!=Integer.MAX_VALUE)
					path[i][j]= i;
				else
					path[i][j]=-1;
			}
		}

        //update matrix exactly n times
		for (int k = 0; k < n; k++)
		{
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					if (a[i][k] != Integer.MAX_VALUE && a[k][j] != Integer.MAX_VALUE && (a[i][k]+a[k][j]<a[i][j]))
					{
						a[i][j] = a[i][k]+a[k][j];
						path[i][j] = path[k][j];
					}
				}

                //detect -ve cycle if diagonal element is -ve
				if (a[i][i] < 0)
				{
					System.out.println("Negative Weight Cycle Found!!");
					return;
				}
			}
		}
		
	}

	public static void main(String[] args)
	{
	    Scanner scan=new Scanner(System.in);
	    
		//number of vertices 
		n = 4;//scan.nextInt();
		
		//number of edges
		int m = 5;//scan.nextInt();


		path=new int[n][n];
		
		int[][] a = new int[n][n];

		for(int[]b:a)
            Arrays.fill(b,Integer.MAX_VALUE);
        
        for(int i=0;i<n;i++)
            a[i][i]=0;
            
        // x is an array of edges from x[i][0] -> x[i][1]    
		int [][]x = { {0,2} , {1,0} , {1,2} , {2,3} ,{3,1}};
		//r is an array on respective edge of x[i]
        int [] r  = { -2 , 4 , 3 , 2 , -1 };  
        
        int p,q,s;
        for(int i=0;i<m;i++)    
        {
            p=x[i][0];
            q=x[i][1];
            s=r[i];
            a[p][q]=s;
        }
   
		floydWarshell(a);
		printSolution();
	}
}