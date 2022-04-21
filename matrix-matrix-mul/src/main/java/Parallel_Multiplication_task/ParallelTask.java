<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/ParallelTask.java
package anderscg.itf23019.project9;
========
package Parallel_Multiplication_task;
>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/Parallel_Multiplication_task/ParallelTask.java

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class ParallelTask extends RecursiveTask<long[]>{
	
	private static final long serialVersionUID = 935729182687362668L;
	
	private long[][] matrix;
	private int start, end;
	private long[] result = {0, 0};
	private int threshold = 1_000;
	
	public ParallelTask(long[][] matrix, int start, int end, long[] result)
	{
		this.matrix = matrix;
		this.start = start;
		this.end = end;
		this.result = result;
	}

	@Override
	protected long[] compute()
	{
		if ((end-start) < threshold)
		{
			calculate(matrix, start, end, result);
		}
		else
		{
			int middle = (end + start)/2;
			
			ParallelTask t1 = new ParallelTask(matrix, start, middle, result);
			ParallelTask t2 = new ParallelTask(matrix, middle+1, end, result);
			
			invokeAll(t1, t2);
			
			t1.join();
			t2.join();
		}
		
		return result;
	}


	private void calculate(long[][] matrix, int start, int end, long[] result)
	{

		int indexSize = matrix.length - 1;
		for(int i = start; i < end; i++) {
			
			result[0] =+ matrix[i][i];
			result[1]+= matrix[i][indexSize - i]; 
		}
		
	}

}