package com.vertica.birthdaysorter.executor;

import java.util.Collections;
import java.util.List;

import com.vertica.birthdaysorter.exception.BirthdaySorterException;
import com.vertica.birthdaysorter.model.BirthdayVO;
import com.vertica.birthdaysorter.service.CustomDateSorter;
import com.vertica.birthdaysorter.service.FileParser;
import com.vertica.birthdaysorter.service.OutputPrinter;

/**
 * @author i5mag
 *
 */
public class BirthdaySorterExecutor {
	
	private FileParser fileParser;
	private OutputPrinter outputPrinter;
	private CustomDateSorter customDateSorter;
	
	public synchronized void readAndSort(String filePath, int sortingType) throws BirthdaySorterException{
		fileParser = new FileParser();
		outputPrinter = new OutputPrinter();
		customDateSorter = new CustomDateSorter();
		
		List<BirthdayVO> birthdayVOList = fileParser.parseInputFile(filePath);
		
		if(sortingType == 1) {
			Collections.sort(birthdayVOList);
		} else if(sortingType == 2) {
			customDateSorter.quickSort(birthdayVOList);
		} else {
			throw new BirthdaySorterException("The entered sort type is not valid.  Please try again.");
		}
		
		outputPrinter.print(birthdayVOList);
	}
	
}
