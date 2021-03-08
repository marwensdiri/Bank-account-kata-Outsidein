package com.bank.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.NotImplementedException;

public class Clock {

	private static final DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String todayAsString() {
		return today().format(date);
	}

	protected LocalDate today() {
		return LocalDate.now();
	}

}
