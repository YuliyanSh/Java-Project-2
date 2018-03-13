package projects.matrix_multiplication;

import java.io.DataInputStream;
import java.io.IOException;

public class StreamReader 
{
	
	public static double[][] readFromStream (DataInputStream dis)
	{
		double[][] result = null;
		
		try
		{
			int numberOfRows = dis.readInt();
			int numberOfColumns = dis.readInt();
			result = new double [numberOfRows][numberOfColumns];
			for (int i = 0; i < numberOfRows; i++)
			{
				for (int j = 0; j < numberOfColumns; j++)
				{
					result[i][j] = dis.readDouble();
				}
			}
		}
		catch (IOException IOEx)
		{
			System.out.println ("IO exception" + IOEx);
		}
		
		return result;	
	}
	
}
