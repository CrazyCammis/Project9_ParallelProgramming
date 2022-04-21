<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/Serial.java
package anderscg.itf23019.project9;
========
package no.hiof.itf23019.matrix_matrix_mul.serial;
>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/no/hiof/itf23019/matrix_matrix_mul/serial/Serial.java

public class Serial {
	
	public long[] multiply(long[][] matrix1)
	{
		
		long dig1 = 0, dig2 = 0;
		
		
		int indexSize = matrix1.length - 1;
		
		for(int i = 0; i < matrix1.length; i++) {
			
			
			long m1= matrix1[i][i];
			long m2 =  matrix1[indexSize - i][indexSize - i];
			
			String holde1 =  "matrix1[" + i +"]["+i+"]";
			String holde2 =  "matrix2[" + i +"]["+(indexSize - i)+"]";
			
			 dig1+= m1;
			 dig2+= m2;
			
			
			
		}
		long[] result = {dig1, dig2};
		
		return result;
	}
}
