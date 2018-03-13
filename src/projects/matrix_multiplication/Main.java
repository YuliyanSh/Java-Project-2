package projects.matrix_multiplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import projects.matrix_multiplication.linear.MatrixMultiplicationLinear;
import projects.matrix_multiplication.parallel.MatrixMultiplicationParallel;


public class Main 
{
	//a file where we'll keep the linear and parallel elapsed time
	public static DataOutputStream dosElapsedTime = null;
	
	public static void main(String[] args) throws IOException, InapropriateSizeForMultiplicationException
	{
		DataInputStream disLeft = null;
		DataInputStream disRight = null;
		double[][] left = null;
		double[][] right = null;
		//read the two matrices and create the timeElapsed file
		try
		{
			disLeft = new DataInputStream (new FileInputStream ("D:\\Program Files\\Eclipse\\workspace\\Matrix_Multiplication\\tests\\Ex1\\left.bin"));
			disRight = new DataInputStream (new FileInputStream ("D:\\Program Files\\Eclipse\\workspace\\Matrix_Multiplication\\tests\\Ex1\\right.bin"));
			dosElapsedTime = new DataOutputStream (new FileOutputStream("D:\\Program Files\\Eclipse\\workspace\\Matrix_Multiplication\\tests\\Ex1\\timeElapsed.txt"));
			left = StreamReader.readFromStream (disLeft);
			right = StreamReader.readFromStream (disRight);
		} // file might be missing
		catch (IOException IOEx)
		{
			System.out.println ("IO exception" + IOEx);
		}
		finally
		{
			StreamCloser.closeStream (disLeft);
			StreamCloser.closeStream (disRight);
		}
	
	//////////////////////////
	
		DataOutputStream disResultLinear = null;
		DataOutputStream disResultParallel = null;
		MatrixMultiplication multiplicationLinear = new MatrixMultiplicationLinear();
		MatrixMultiplication multiplicationParallel = new MatrixMultiplicationParallel();
		double[][] result = null;
		//do linear and parallel multiplication and write the result in two seperate files
		//along with a timeElapsed file containing the runtime of both methods
		try
		{
			disResultLinear = new DataOutputStream (new FileOutputStream ("D:\\Program Files\\Eclipse\\workspace\\Matrix_Multiplication\\tests\\Ex1\\ResultLinear.txt"));
			result = new double [left.length][right[0].length];
			//Linear multiplication
			try
			{
				result = multiplicationLinear.multiply(left, right, 0);
				Logger.logToFile(disResultLinear, result);
			}
			catch(IOException IOEx)
			{
				System.out.println("IO exception" + IOEx);
			}
			
			disResultParallel = new DataOutputStream (new FileOutputStream ("D:\\Program Files\\Eclipse\\workspace\\Matrix_Multiplication\\tests\\Ex1\\ResultParallel.txt"));
			//Parallel multiplication
			int coresNumber = Runtime.getRuntime().availableProcessors();
			for (int i = 1; i <= 2*coresNumber; i++)
			{
				try
				{
					result = multiplicationParallel.multiply(left, right, i);
				}
				catch(IOException IOEx)
				{
					System.out.println("IO exception" + IOEx);
				}
			}
			Logger.logToFile (disResultParallel, result);
		}
		catch(IOException IOEx)
		{
			System.out.println("IO exception" + IOEx);
		}
		
		//Closing used resources and showing an end message
		finally
		{
			StreamCloser.closeStream(disResultLinear);
			StreamCloser.closeStream(disResultParallel);
			StreamCloser.closeStream(dosElapsedTime);
			System.out.println("Program has finished");
		}
	}
	
}
