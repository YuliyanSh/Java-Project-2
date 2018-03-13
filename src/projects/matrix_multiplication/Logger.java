package projects.matrix_multiplication;

import java.io.DataOutputStream;
import java.io.IOException;

public class Logger 
{

	public static void logToFile (DataOutputStream dos, double[][] result)
	{
		//Sequence used by operating system to separate lines in text files
		String nl = System.getProperty ("line.separator");
		try
		{
			for (int i = 0; i < result.length; i++)
			{
				for (int j = 0; j < result[0].length; j++)
				{
					dos.writeBytes (result[i][j] + " ");
				}
				dos.writeBytes (nl);
			}
		}
		catch (IOException IOEx)
		{
			System.out.println ("IO exception: " + IOEx);
		}
	}
	
	public static void logTime (long time, String message)
	{
		try
		{
			Main.dosElapsedTime.writeBytes (message + " ");
			Main.dosElapsedTime.writeBytes (time + " ms");
			String nl = System.getProperty ("line.separator");
			Main.dosElapsedTime.writeBytes (nl);
		}
		catch (IOException IOEx)
		{
			System.out.print("IO exception: " + IOEx);
		}
	}
	
}
