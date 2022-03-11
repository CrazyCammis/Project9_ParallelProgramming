package no.hiof.itf23019.matrix_matrix_mul.parallel;

import java.util.concurrent.ForkJoinPool;


public class MatrixMatrixMulParallel {

	public long multiply(long[][] matrix1, long[][] matrix2) {
		
		System.out.println("Parallel Running ....");
		
		int N = matrix1.length;
		int P = matrix2[0].length;
		long result = 0;
	
		//TODO: Code for Parallel version

		return result;
	}
}
