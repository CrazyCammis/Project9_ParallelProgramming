package no.hiof.itf23019.matrix_matrix_mul.parallel;
import java.util.concurrent.RecursiveAction;




public class MatrixMatrixMulTask extends RecursiveAction {

	private static final long serialVersionUID = 935729182687362668L;
	
	private  long[][] matrix1;
	private long[][] matrix2;
	private int startIndex, endIndex;
	private long result;
	private int threshold = 1000;


	public MatrixMatrixMulTask(long[][] matrix1, long[][] matrix2, int startIndex, int endIndex, long result) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.result = result;
	}

	@Override
	// DO WE HAVE TO ADD A RESULT = T1.getsum+t2.getsum?
	protected void compute() {
		//TODO: Code for Parallel version
		if((endIndex - startIndex) < threshold) {
			matrixCalc();
		}
		else {
			
			//UPDATE THIS
			/*
			int middle = (endIndex+startIndex)/2;
			
			MatrixMatrixMulTask task1 = new MatrixMatrixMulTask(matrix1, matrix2, startIndex, middle+1, result);
			MatrixMatrixMulTask task2 = new MatrixMatrixMulTask(matrix1, matrix2, middle+1, endIndex, result);
			invokeAll(task1,task2);

			
			
			int middle = (endIndex+startIndex)/3;
			MatrixMatrixMulTask task1 = new MatrixMatrixMulTask(matrix1, matrix2, startIndex, middle+1, result);
			MatrixMatrixMulTask task2 = new MatrixMatrixMulTask(matrix1, matrix2, middle+1, (middle*2)+1, result);
			MatrixMatrixMulTask task3 = new MatrixMatrixMulTask(matrix1, matrix2, (middle*2)+1, endIndex, result);
			invokeAll(task1,task2, task3);
			//*/
			
			
			int middle = (endIndex+startIndex)/4;
			MatrixMatrixMulTask task1 = new MatrixMatrixMulTask(matrix1, matrix2, startIndex, middle, result);
			MatrixMatrixMulTask task2 = new MatrixMatrixMulTask(matrix1, matrix2, middle+1, middle*2+1, result);
			MatrixMatrixMulTask task3 = new MatrixMatrixMulTask(matrix1, matrix2, middle*2+1, middle*3+1, result);
			MatrixMatrixMulTask task4 = new MatrixMatrixMulTask(matrix1, matrix2, middle*3+1, endIndex, result);
			
			invokeAll(task1,task2, task3, task4);					
		}
		
	}

	
	//TODO FIX THIS REMEBER RESULT IS JUST ONE LONG NOT ARRAY 
	private void matrixCalc() {		
		//length
		int N = matrix2.length;
		int K = matrix2[0].length;
		for(int  i= startIndex; i < endIndex; i++) {
			//height
			for(int j = 0; j < K; j++) {
				for(int p = 0; p < N; p++) {	
					result[i][j] += matrix1[i][p]* matrix2[p][j];		
				}	
			}	
		}
		
	}

	
	
}