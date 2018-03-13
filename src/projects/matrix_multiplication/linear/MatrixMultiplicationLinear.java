package projects.matrix_multiplication.linear;

import java.io.IOException;

import projects.matrix_multiplication.InapropriateSizeForMultiplicationException;
import projects.matrix_multiplication.Logger;
import projects.matrix_multiplication.MatrixMultiplication;


public class MatrixMultiplicationLinear implements MatrixMultiplication 
{

	@Override
	public double[][] multiply (double[][] leftMatrix, double[][] rightMatrix, int unused) throws IOException, InapropriateSizeForMultiplicationException
	{
		//if leftMatrix has n*m size and rightMatrix has k*l size we check if m = k
		if (leftMatrix[0].length != rightMatrix.length)
		{
			throw new InapropriateSizeForMultiplicationException ("Cannot multiply matrices of such size!");
		}
		//if leftMatrix has n*m size and rightMatrix has k*l size, resultMatrix will be n*l
		double [][] resultMatrix = new double [leftMatrix.length][rightMatrix[0].length];
		
		//Start counting the time needed for multiplying
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < leftMatrix.length; i++)
		{
			for (int j = 0; j < rightMatrix[0].length; j++)
			{
				for (int k = 0; k < rightMatrix.length; k++)
				{
					//multiply i-th row from leftMatrix with j-th column from rightMatrix
					resultMatrix[i][j] += leftMatrix[i][k]*rightMatrix[k][j];
				}
			}
		}
		
		//Find estimated time for multiplication 
		long estimatedTime = System.currentTimeMillis() - startTime;
		//Log the estimated time in a file
		Logger.logTime(estimatedTime, "Linear multiplication time:             ");
		
		return resultMatrix;
	}
	
}
