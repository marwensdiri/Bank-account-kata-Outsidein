package com.bank.junit;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Transaction;
import com.bank.service.Console;
import com.bank.service.StatementPrinter;



@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {


	private static final List<Transaction> NO_Transaction = Collections.emptyList();
	private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

	@Mock Console console;
	private StatementPrinter statementPrinter;
	private List<Transaction> transactions = new ArrayList<Transaction>();


	@Before
	public void setUp() throws Exception {
		statementPrinter = new StatementPrinter(console);	
	}

	@Test
	public void print_header() {
		statementPrinter.print(NO_Transaction);

		verify(console).printLine(STATEMENT_HEADER);
	}
	
	@Test
	public void print_all_transactions() {

		transactions.add(new Transaction("01/04/2014", 1000));
		transactions.add(new Transaction("02/04/2014", -100));
		transactions.add(new Transaction("10/04/2014", 500));
		statementPrinter.print(transactions);

		InOrder inOrder = Mockito.inOrder(console);
		inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
		inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}
}
