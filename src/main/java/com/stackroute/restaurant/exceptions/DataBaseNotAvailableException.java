package com.stackroute.restaurant.exceptions;

@SuppressWarnings("serial")
public class DataBaseNotAvailableException extends Exception {

	public DataBaseNotAvailableException() {
		super();
	}

	public DataBaseNotAvailableException(String message) {
		super(message);

	}

	public void handleUserNotFoundException() {

	}

}
