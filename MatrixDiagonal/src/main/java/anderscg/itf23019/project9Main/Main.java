package anderscg.itf23019.project9Main;

import anderscg.itf23019.project9Main.serial.Serial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args ) throws FileNotFoundException {
    	int N = 10_000;
		int M = 1_000;
		int P = 1_000;
		
		File MatrixA = new File("MatrixA.txt");
		File MatrixB = new File("MatrixB.txt");
		

		long[][] matrix1 = readFile_ToMatrix(MatrixA);
		long[][] matrix2 = readFile_ToMatrix(MatrixB);
		
		

		Serial serial = new Serial();
		ParallelStart parallel = new ParallelStart();


		long startTime, endTime, serialTime, parTime;

		//Serial
		startTime = System.currentTimeMillis();
		long resultSerial =  serial.multiply(matrix1);
		endTime = System.currentTimeMillis();
		serialTime = endTime - startTime;
		
		
		
		//Parallel
		startTime = System.currentTimeMillis();
		long resultParallel = parallel.calculate(matrix1);
		endTime = System.currentTimeMillis();
		parTime = endTime - startTime;
		
		
		
		//see if they are the same
		compareResults(resultSerial, resultParallel);


		System.out.println("serialTime=" + serialTime);
		System.out.println("parTime=" + parTime);

		float speedup = parTime/serialTime;
		System.out.print("Speed up is : " + speedup);
		readToFile("resultSerial.txt", resultSerial);
		readToFile("resultPar.txt", resultParallel);
		
		
    }
   
    //small scale testing 
	private static void compareResults(long resultSerial, long resultParallel)
	{
		if (resultSerial == resultParallel)
            System.out.println("The results are the same"); 
        else
            System.out.println("The results are NOT the same"); 
	}
	
	
    
    
	private static void readToFile(String filename, long resultMatrix) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);
		
			writer.println(resultMatrix);
		
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
}
