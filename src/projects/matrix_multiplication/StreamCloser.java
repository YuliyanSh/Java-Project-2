package projects.matrix_multiplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class StreamCloser 
{
	
	public static void closeStream (DataInputStream dis)
	{
		if (dis != null)
		{
			try
			{
				dis.close();
			}
			catch (IOException IOEx)
			{
				System.out.println ("Stream can't be closed! " + IOEx);
			}
		}
	}
	
	public static void closeStream (DataOutputStream dos)
	{
		if (dos != null)
		{
			try
			{
				dos.close();
			}
			catch (IOException IOEx)
			{
				System.out.println ("Stream can't be closed! " + IOEx);
			}
		}
	}
	
}
