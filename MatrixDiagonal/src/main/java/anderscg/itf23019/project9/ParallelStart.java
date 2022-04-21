package anderscg.itf23019.project9;



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
