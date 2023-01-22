package com.godisultimate.lms.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SuppressWarnings("serial")
public class ApplicationExceptions extends Exception {

	public int id = 0;

	//Logger logger = LoggerFactory.getLogger(BannersDataController.class);

	public ApplicationExceptions() {
		super();
	}

	public ApplicationExceptions(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationExceptions(String message) {
		super(message);
		//logger.error(message);
	}

	public ApplicationExceptions(int id, String message) {
		super(message);
		this.id = id;
	}

	public ApplicationExceptions(Throwable cause) {
		super(cause);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
