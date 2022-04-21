<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/Main.java
package anderscg.itf23019.project9;
========
package no.hiof.itf23019.matrix_matrix_mul;
>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/no/hiof/itf23019/matrix_matrix_mul/Main.java

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import Parallel_Multiplication_task.ParallelStart;
import no.hiof.itf23019.matrix_matrix_mul.serial.Serial;


public class Main 
{
    public static void main( String[] args ) throws FileNotFoundException {
    	int N = 10_000;
		int M = 1_000;
		int P = 1_000;
		
		File MatrixA = new File("test1.txt");
		
		//File compareator = new File("MatrixB.txt");

		long[][] matrix1 = readFile_ToMatrix(MatrixA);
		
		
		
		//long trueResult = trueReultReader(compareator);
		

		Serial serial = new Serial();
		ParallelStart parallel = new ParallelStart();
		
		
		//TO BE FIXED
		long startTime, endTime, serialTime, parTime;
		
		startTime = System.currentTimeMillis();
		long[] resultSerial =  serial.multiply(matrix1);
		long dig1Ser= resultSerial[0];
		long dig2Ser= resultSerial[0];

		
		endTime = System.currentTimeMillis();
		serialTime = endTime - startTime;
		
		
		
		//TO BE FIXED
		startTime = System.currentTimeMillis();
		long[] resultParallel = parallel.calculate(matrix1);
		long dig1Par= resultParallel[0];
		long dig2Par= resultParallel[1];

		endTime = System.currentTimeMillis();
		parTime = endTime - startTime;
		
		
		
<<<<<<<< HEAD:MatrixDiagonal/src/main/java/anderscg/itf23019/project9/Main.java
		//see if they are the same
		compareResults(dig1Ser, dig1Par, dig2Ser, dig2Par);
		System.out.println("both are the same"); 
		
		//compareResults(resultSerial, resultParallel);
		//System.out.println("both are the same as the the true result"); 
========
		//can be used for small scale testing 
		compareResults(resultSerial, resultParallel);

>>>>>>>> parent of 9b82ec1 (updates?):matrix-matrix-mul/src/main/java/no/hiof/itf23019/matrix_matrix_mul/Main.java

		System.out.println("serialTime=" + serialTime);
		System.out.println("parTime=" + parTime);

		//TODO: compute speedup
		
		float speedup = parTime/serialTime;
		System.out.print("Speed up is : " + speedup);
		readToFile("resultSerial.txt", resultSerial);
		readToFile("resultPar.txt", resultParallel);
		
		
    }
   
    //small scale testing 
	private static void compareResults(long dig1Ser, long dig1Par, long dig2Ser, long dig2Par)
	{
		if (dig1Ser == dig1Par && dig2Ser == dig2Par)
            System.out.println("The results are the same"); 
        else
            System.out.println("The results are NOT the same"); 
	}
	
	
    
    
	private static void readToFile(String filename, long[] result) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);
		
			writer.println(result);
		
		writer.close();
	}
	
	
	private static long[][] readFile_ToMatrix(File matrix) throws FileNotFoundException {

    	Scanner scanner1 = new Scanner(matrix);
		Scanner scanner2 = new Scanner(matrix);
		Scanner scanner3 = new Scanner(matrix);

		scanner1.nextLine();	// Skips first line
		scanner2.nextLine();
		scanner3.nextLine();

    	int Rows = 0;
    	int Columns;
    	int Count = 0;

    	while(scanner1.hasNextLine()){ // Find rows
			scanner1.nextLine();
			Rows++;
		}
		while(scanner2.hasNextInt()){ // Find elements
			scanner2.nextInt();
			Count++;
		}

		Columns = Count/Rows;  // Calculate columns

		long[][] k = new long[Rows][Columns];
		// Creating matrix
		for (int i = 0; i < Rows; i++)
			for(int j = 0; j < Columns; j++) {
				k[i][j] = scanner3.nextInt();
			}
		scanner1.close();
		scanner2.close();
		scanner3.close();
		
		return k;	
		
	}
	private static long trueReultReader(File result) throws FileNotFoundException {
   	 Scanner sc = new Scanner(new File("myNumbers"));
   	 long along = 0;
        while (sc.hasNextLong()) {
            along = sc.nextLong();
        }
       
		return along;
   }
}
