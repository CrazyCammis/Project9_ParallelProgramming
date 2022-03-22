package Parallel_Multiplication_task;

import java.util.concurrent.ForkJoinPool;

public class ParallelStart {
	
	public long calculate(long[][] matrix1, long[][] matrix2) {
		
		System.out.println("Parallel running...");
		
		int N = matrix1.length;
		long result = 0;
		
		ParallelTask task = new ParallelTask(matrix1, matrix2, 0, N, result);
		ForkJoinPool pool = new ForkJoinPool();
		result = pool.invoke(task);
		
		return result;
	}

}
