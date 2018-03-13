package projects.matrix_multiplication;

import java.io.IOException;


public interface MatrixMultiplication 
{
	double [][] multiply (double[][] leftMatrix, double [][] rightMatrix, int threads) throws IOException, InapropriateSizeForMultiplicationException;
}
