package anderscg.itf23019.project9Main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class ParallelTask extends RecursiveTask<Long>{
	
	private static final long serialVersionUID = 935729182687362668L;
	
	private long[][] matrix;
	private int start, end;
	private long result;
	private int threshold = 1_000;
	
	public ParallelTask(long[][] matrix, int start, int end, long result)
	{
		this.matrix = matrix;
		this.start = start;
		this.end = end;
		this.result = result;
	}

	@Override
	protected Long compute()
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
			
			try {
				result = t1.get() + t2.get();
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}	
		}
		
		return result;
	}


	private void calculate(long[][] matrix, int start, int end, long result)
	{
		int indexSize = matrix.length - 1;
		for(int i = start; i < end; i++) {
			
			result =+ matrix[i][i] + matrix[i][indexSize - i]; 
		}
	}

}