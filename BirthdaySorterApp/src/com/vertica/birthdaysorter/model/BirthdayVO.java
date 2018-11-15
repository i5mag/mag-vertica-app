package com.vertica.birthdaysorter.model;

import java.util.Calendar;
import java.util.Date;

public class BirthdayVO implements Comparable<BirthdayVO> {
	
	private  String personId;
	private Date birthDate;
	
	public BirthdayVO(String personId, Date birthDate) {
		super();
		this.personId = personId;
		this.birthDate = birthDate;
	}

	public String getPersonId() {
		return personId;
	}
	
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthdayVO other = (BirthdayVO) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthDate);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(personId);
		buffer.append("\t");
		buffer.append(calendar.get(Calendar.MONTH) + 1);
		buffer.append("\t");
		buffer.append(calendar.get(Calendar.DATE));
		buffer.append("\t");
		buffer.append(calendar.get(Calendar.YEAR));
		
		return buffer.toString();
	}

	@Override
	public int compareTo(BirthdayVO birthdayVO) {
		return this.birthDate.compareTo(birthdayVO.getBirthDate());
	}	
}
