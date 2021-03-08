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


	private static final List<Transaction> NO_Transaction = Collections.EMPTY_LIST;
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
}
