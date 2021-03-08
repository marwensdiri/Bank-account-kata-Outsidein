package com.bank.service;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import com.bank.domain.Transaction;

public class StatementPrinter {

	
	private Console console;
	private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
	private DecimalFormat decimalFormatter = new DecimalFormat("#.00");
	
	public StatementPrinter(Console console) {
		this.console = console;
	}

	public void print(List<Transaction> transactions) {
		console.printLine(STATEMENT_HEADER);
		AtomicInteger balance = new AtomicInteger();

		List<String> statementLine = transactions.stream().map( transaction -> {
			 return transaction.getToday()
					+" | " + decimalFormatter.format(transaction.getAmount()) 
					+" | " + decimalFormatter.format(balance.addAndGet(transaction.getAmount())) ;
		}).collect(Collectors.toList());

		Collections.reverse(statementLine);
		statementLine.forEach(t -> console.printLine(t));
	}
}