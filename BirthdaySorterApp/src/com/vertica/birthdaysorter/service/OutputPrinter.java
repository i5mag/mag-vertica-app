package com.vertica.birthdaysorter.service;

import java.util.List;

import com.vertica.birthdaysorter.model.BirthdayVO;

/**
 * @author i5mag
 *
 */
public class OutputPrinter {

	public synchronized void print(List<BirthdayVO> birthdayVOList) {
		
		long threadId = Thread.currentThread().getId();
		
		System.out.println("Thread ID\tPerson ID\tMonth\tDay\tYear");
		birthdayVOList.forEach((vo) -> System.out.println(threadId + "\t\t\t" +vo.toString()));
	}
	
}
