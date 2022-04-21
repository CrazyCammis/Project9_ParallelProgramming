<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/ParallelStart.java
package anderscg.itf23019.project9;
========
package Parallel_Multiplication_task;
>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/Parallel_Multiplication_task/ParallelStart.java

import java.util.concurrent.ForkJoinPool;

public class ParallelStart {
	
	public long[] calculate(long[][] matrix) {
		
		System.out.println("Parallel running...");
		
		int N = matrix.length;
		long[] result = {0,0};
		
		ParallelTask task = new ParallelTask(matrix, 0, N, result);
		ForkJoinPool pool = new ForkJoinPool();
		result = pool.invoke(task);
		
		return result;
	}

}
