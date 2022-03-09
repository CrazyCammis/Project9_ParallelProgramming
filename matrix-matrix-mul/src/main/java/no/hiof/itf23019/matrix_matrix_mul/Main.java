package no.hiof.itf23019.matrix_matrix_mul;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import no.hiof.itf23019.matrix_matrix_mul.parallel.MatrixMatrixMulParallel;
import no.hiof.itf23019.matrix_matrix_mul.serial.MatrixMatrixMulSerial;

public class Main 
{
    public static void main( String[] args ) throws FileNotFoundException {
    	int N = 10_000;
		int M = 1_000;
		int P = 1_000;
		
		File MatrixA = new File("MatrixA.txt");
		File MatrixB = new File("MatrixB.txt");
		

		long[][] matrix1 = readFile_ToMatrix(MatrixA);
		long[][] matrix2 = readFile_ToMatrix(MatrixB);
		
		
		MatrixMatrixMulSerial matrixMatrixMulSerial = new MatrixMatrixMulSerial();
		MatrixMatrixMulParallel matrixMatrixMulParallel = new MatrixMatrixMulParallel();
		
		long startTime, endTime, serialTime, parTime;
		startTime = System.currentTimeMillis();
		long[][] resultSerial =  matrixMatrixMulSerial.multiply(matrix1, matrix2);
		endTime = System.currentTimeMillis();
		serialTime = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		long[][] resultParallel = matrixMatrixMulParallel.multiply(matrix1, matrix2);
		endTime = System.currentTimeMillis();
		parTime = endTime - startTime;
		
		compareResults(resultSerial, resultParallel);


		System.out.println("serialTime=" + serialTime);
		System.out.println("parTime=" + parTime);

		//TODO: compute speedup
		
    }
   
	private static void compareResults(long[][] arr1, long[][] arr2)
	{
		if (Arrays.deepEquals(arr1, arr2)) 
            System.out.println("The results are the same"); 
        else
            System.out.println("The results are NOT the same"); 
	}
	private static void readToFile(String filename, long[][] resultMatrix) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);
		for (long[] longs : resultMatrix) {
			writer.println(Arrays.toString(longs));
		}
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
		return k;
	}
}