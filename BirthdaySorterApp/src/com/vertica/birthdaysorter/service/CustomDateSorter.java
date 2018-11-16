package com.vertica.birthdaysorter.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.vertica.birthdaysorter.model.BirthdayVO;

/**
 * @author i5mag
 *
 */
public class CustomDateSorter {

	public List<BirthdayVO> quickSort(List<BirthdayVO> birthdayVOList)
	{
	    if (birthdayVOList.size() <= 1) 
	        return birthdayVOList;

	    List<BirthdayVO> sortedList = new CopyOnWriteArrayList<BirthdayVO>();
	    List<BirthdayVO> lesserList = new CopyOnWriteArrayList<BirthdayVO>();
	    List<BirthdayVO> greaterList = new CopyOnWriteArrayList<BirthdayVO>();
	    
	    BirthdayVO pivot = birthdayVOList.get(birthdayVOList.size()-1);
	    
	    for (int i = 0; i < birthdayVOList.size()-1; i++) {
	        if (birthdayVOList.get(i).getBirthDate().compareTo(pivot.getBirthDate()) < 0)
	        	lesserList.add(birthdayVOList.get(i)); 
	        else
	        	greaterList.add(birthdayVOList.get(i));
	    }

	    lesserList = quickSort(lesserList);
	    greaterList = quickSort(greaterList);

	    lesserList.add(pivot);
	    lesserList.addAll(greaterList);
	    sortedList = lesserList;

	    return sortedList;
	}
	
}
