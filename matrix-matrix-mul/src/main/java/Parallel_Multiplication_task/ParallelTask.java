package Parallel_Multiplication_task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class ParallelTask extends RecursiveTask<Long>{
	
	private static final long serialVersionUID = 935729182687362668L;
	
	private long[][] matrix1;
	private long[][] matrix2;
	private int start, end;
	private long result;
	private int threshold = 1_000;
	
	public ParallelTask(long[][] matrix1, long[][] matrix2, int start, int end, long result)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.start = start;
		this.end = end;
		this.result = result;
	}

	@Override
	protected Long compute()
	{
		if ((end-start) < threshold)
		{
			calculate(matrix1, matrix2, start, end, result);
		}
		else
		{
			int middle = (end + start)/2;
			
			ParallelTask t1 = new ParallelTask(matrix1, matrix2, start, middle, result);
			ParallelTask t2 = new ParallelTask(matrix1, matrix2, middle+1, end, result);
			
			invokeAll(t1, t2);
			
			try {
				result = t1.get() + t2.get();
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}	
		}
		
		return result;
	}


	private void calculate(long[][] matrix1, long[][] matrix2, int start, int end, long result)
	{

		int indexSize = matrix1.length - 1;
		for(int i = start; i < end; i++) {
			
			result =+ matrix1[i][i] + matrix2[i][indexSize - i]; 
		}
	}

}