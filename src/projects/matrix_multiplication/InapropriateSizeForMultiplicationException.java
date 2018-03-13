package projects.matrix_multiplication;

public class InapropriateSizeForMultiplicationException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634675596538250516L;

	public InapropriateSizeForMultiplicationException() 
	{}

	public InapropriateSizeForMultiplicationException (String message) 
	{
		super (message);
	}
	
}
