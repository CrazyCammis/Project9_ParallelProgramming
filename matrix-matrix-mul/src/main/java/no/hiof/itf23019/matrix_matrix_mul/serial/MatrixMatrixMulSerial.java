package no.hiof.itf23019.matrix_matrix_mul.serial;

public class MatrixMatrixMulSerial {
	
	public long[][] multiply(long[][] matrix1, long[][] matrix2)
	{
		
		/*
		System.out.println("Serial Running ....");
		
		int N = matrix1.length;
		System.out.println("N = " + N);
		int M = matrix2.length;
		System.out.println("M = " + M);
		int P = matrix2[0].length;
		System.out.println("Result matrix = " + N + "x" + P);
		
		long[][] result = new long[N][P];
		
		//TODO: Matrix Multiplication
		
		return result;*/
		
		int sum;
		
		int indexSize = matrix1.length - 1;
		for(int i = 0; i < matrix1.length; i++) {
			
			sum = (int) (matrix1[i][i] + matrix2[i][indexSize - i]);
		
	}
}
