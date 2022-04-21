<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/ParallelTask.java
package anderscg.itf23019.project9;
========
package Parallel_Multiplication_task;
>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/Parallel_Multiplication_task/ParallelTask.java

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class ParallelTask extends RecursiveTask<long[]>{
	
	private static final long serialVersionUID = 935729182687362668L;
	
	private long[][] matrix1;
	private long[][] matrix2;
	private int start, end;
	private long[] result = {0, 0};
	private int threshold = 1_000;
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	public ParallelTask(long[][] matrix, int start, int end, long[] result)
=======
	public ParallelTask(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	public ParallelTask(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	public ParallelTask(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	public ParallelTask(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.start = start;
		this.end = end;
		this.result = result;
	}

	@Override
	protected long[] compute()
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
			
			t1.join();
			t2.join();
		}
		
		return result;
	}


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private void calculate(long[][] matrix, int start, int end, long[] result)
=======
	private void calculate(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	private void calculate(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	private void calculate(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
	private void calculate(long[][] matrix1, long[][] matrix2, int start, int end, long result)
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
	{

		int indexSize = matrix1.length - 1;
		for(int i = start; i < end; i++) {
			
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
			result[0] =+ matrix[i][i];
			result[1]+= matrix[i][indexSize - i]; 
=======
			result =+ matrix1[i][i] + matrix2[i][indexSize - i]; 
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
			result =+ matrix1[i][i] + matrix2[i][indexSize - i]; 
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
			result =+ matrix1[i][i] + matrix2[i][indexSize - i]; 
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
=======
			result =+ matrix1[i][i] + matrix2[i][indexSize - i]; 
>>>>>>> parent of 14e51a5 (Merge branch 'main' of https://github.com/CrazyCammis/Project9_ParallelProgramming)
		}
		
	}

}