package com.vertica.birthdaysorter.executor;

import java.util.Collections;
import java.util.List;

import com.vertica.birthdaysorter.model.BirthdayVO;
import com.vertica.birthdaysorter.service.FileParser;
import com.vertica.birthdaysorter.service.OutputPrinter;

public class BirthdaySorterExecutor {
	
	private FileParser fileParser;
	
	
	public synchronized List<BirthdayVO> readAndSort(String filePath, int sortingType) {
		fileParser = new FileParser();
		
		List<BirthdayVO> birthdayVOList = fileParser.parseInputFile(filePath);
		Collections.sort(birthdayVOList);
		
		return birthdayVOList;
	}
	
}
