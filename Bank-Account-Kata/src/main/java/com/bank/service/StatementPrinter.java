package com.bank.service;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import com.bank.domain.Transaction;

public class StatementPrinter {

	
	private Console console;

	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.printLine("DATE | AMOUNT | BALANCE");
	}
}