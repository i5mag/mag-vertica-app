package com.vertica.birthdaysorter.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.vertica.birthdaysorter.exception.BirthdaySorterException;
import com.vertica.birthdaysorter.model.BirthdayVO;

/**
 * @author i5mag
 *
 */
public class FileParser {

	public List<BirthdayVO> parseInputFile(String filePath) throws BirthdaySorterException{
		
		List<BirthdayVO> birthdayVOList = new CopyOnWriteArrayList<BirthdayVO>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		File file = new File(filePath);
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			
			String row;
			while((row = bufferedReader.readLine()) != null) {
				String[] cells = row.trim().split("\\s+");
				String simpleDateInput = new StringBuffer(cells[1]).append("-").append(cells[2]).append("-")
						.append(cells[3]).toString(); 
				birthdayVOList.add(new BirthdayVO(cells[0], simpleDateFormat.parse(simpleDateInput) ));
			}
		} catch (FileNotFoundException ex) {
			throw new BirthdaySorterException("The input file is not found at the specified path.");
		} catch (IOException ex) {
			throw new BirthdaySorterException("Unable to read the input file.");
		} catch (NumberFormatException e) {
			throw new BirthdaySorterException("The input data is invalid/corrupted and could not be processed.");
		} catch (ParseException e) {
			throw new BirthdaySorterException("The input data is invalid/corrupted and could not be processed.");
		}
		
		return birthdayVOList;
		
	}
	
}
