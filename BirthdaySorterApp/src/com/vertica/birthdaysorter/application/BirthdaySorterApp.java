package com.vertica.birthdaysorter.application;

import java.util.Scanner;

import com.vertica.birthdaysorter.executor.BirthdaySorterExecutor;
import com.vertica.birthdaysorter.service.OutputPrinter;

/**
 * @author i5mag
 *
 */
public class BirthdaySorterApp extends Thread {

	private static String filePath;
	private static int sortingType;
	
	private BirthdaySorterExecutor birthdaySorterExecutor;
	private OutputPrinter outputPrinter;
	
	BirthdaySorterApp(BirthdaySorterExecutor birthdaySorterExecutor, OutputPrinter outputPrinter) {
		this.birthdaySorterExecutor = birthdaySorterExecutor;
		this.outputPrinter = outputPrinter;
	}
	
	public void run() {
		outputPrinter.print(birthdaySorterExecutor.readAndSort(filePath, sortingType));
	}
	
	public static void main(String[] args) {
		
		BirthdaySorterExecutor birthdaySorterExecutor = new BirthdaySorterExecutor();
		OutputPrinter outputPrinter = new OutputPrinter();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Birthday Sorter Application !");
		
		System.out.println("Enter the path of the input file:");
		filePath = in.nextLine();
		filePath = "/Users/mahesh/Workspace/STS/mag-vertica-app/BirthdaySorterApp/resources/input.txt";
		
		System.out.println("Select the type of sorting.  Enter 1 for Collection's sorting and 2 for Custom sorting:");
		sortingType = in.nextInt();	
		
		BirthdaySorterApp thread1 = new BirthdaySorterApp(birthdaySorterExecutor, outputPrinter);
		BirthdaySorterApp thread2 = new BirthdaySorterApp(birthdaySorterExecutor, outputPrinter);
		
		thread1.start();
		thread2.start();
	}

}
