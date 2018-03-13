package projects.matrix_multiplication.parallel;

import java.util.concurrent.Callable;

public class MatrixMultiplicationParallelTask implements Callable<double[][]> 
{

    double[][] left;
    double [][] right;
    public double[][] result;
    int start;
    int end;

    public MatrixMultiplicationParallelTask (double[][] left, double[][] right, int start, int end) 
    {
        this.left = left;
        this.right = right;
        this.result = new double[left.length][right[0].length];
        this.start = start;
        this.end = end;
    }

    @Override
    public double[][] call() 
    {
        for (int i = start; i < end; i++) 
        {
            for (int j = 0; j < right.length; j++) 
            {
                for (int k = 0; k < right[0].length; k++) 
                {
                    result[i][k] += left[i][j] * right[j][k];
                }
            }
        }
        //result - matrix with end-start columns and right[0].length rows
        return result;
    }

}
