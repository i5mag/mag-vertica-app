package com.vertica.birthdaysorter.exception;

public class BirthdaySorterException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public BirthdaySorterException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
