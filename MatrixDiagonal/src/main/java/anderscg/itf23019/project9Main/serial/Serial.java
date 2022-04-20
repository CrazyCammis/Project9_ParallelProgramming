package anderscg.itf23019.project9Main.serial;

public class Serial {
	
	public long multiply(long[][] matrix1)
	{
		
		long sum = 0;
		
		int indexSize = matrix1.length - 1;
		
		for(int i = 0; i < matrix1.length; i++) {
			long m1= matrix1[i][i];
			long m2 =  matrix1[indexSize - i][indexSize - i];
			
			String holde1 =  "matrix1[" + i +"]["+i+"]";
			String holde2 =  "matrix2[" + i +"]["+(indexSize - i)+"]";
			
			long thisRound= m1 +m2;
			System.out.println("Result matrix  " + holde1 + "+" + holde2 + " = " + Math.floorDiv(thisRound, 2));
			
			sum =+ thisRound; 
		}
		return sum;
	}
}