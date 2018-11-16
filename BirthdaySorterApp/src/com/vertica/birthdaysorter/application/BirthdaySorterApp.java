package com.vertica.birthdaysorter.application;

import java.util.Scanner;

import com.vertica.birthdaysorter.exception.BirthdaySorterException;
import com.vertica.birthdaysorter.executor.BirthdaySorterExecutor;

/**
 * @author i5mag
 *
 */
public class BirthdaySorterApp extends Thread {

	private static String filePath;
	private static int sortingType;
	
	private BirthdaySorterExecutor birthdaySorterExecutor;
	
	BirthdaySorterApp(BirthdaySorterExecutor birthdaySorterExecutor) {
		this.birthdaySorterExecutor = birthdaySorterExecutor;
	}
	
	public void run(){
		try
		{
			long threadStartTime = System.currentTimeMillis();
			birthdaySorterExecutor.readAndSort(filePath, sortingType);
			System.out.println("Thread id " + currentThread().getId() + " took " + (System.currentTimeMillis()-threadStartTime) + " milliseconds to process \n");
		}
		catch(BirthdaySorterException customEx)
		{
			System.err.println(customEx.getErrorMessage());
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		BirthdaySorterExecutor birthdaySorterExecutor = new BirthdaySorterExecutor();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Birthday Sorter Application !");

		System.out.println("Enter the path of the input file:");
		filePath = in.nextLine();
		filePath = "/Users/mahesh/Workspace/STS/mag-vertica-app/BirthdaySorterApp/resources/input.txt";

		System.out.println("Select the type of sorting.  Enter 1 for Collection's sorting and 2 for Custom sorting:");
		sortingType = in.nextInt();

		BirthdaySorterApp thread1 = new BirthdaySorterApp(birthdaySorterExecutor);
		BirthdaySorterApp thread2 = new BirthdaySorterApp(birthdaySorterExecutor);

		thread1.start();
		thread2.start();
	}

}
