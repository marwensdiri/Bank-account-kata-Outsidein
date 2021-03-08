package com.bank.acceptance;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Account;
import com.bank.repositories.TransactionRepository;
import com.bank.service.Clock;
import com.bank.service.Console;
import com.bank.service.StatementPrinter;

@RunWith(MockitoJUnitRunner.class)
public class PrintstatementTest {

		@Mock Console console;
		private Account account;
		private TransactionRepository transactionRepository;
		private StatementPrinter statementPrinter;
		private Clock clock;
		
		@Before
		public void setUp() throws Exception {
			transactionRepository = new TransactionRepository(clock);
			statementPrinter = new StatementPrinter(console);
			account = new Account(transactionRepository, statementPrinter);
		}

	@Test
	public void printStatement_containing_all_transtactions() {

		given(clock.todayAsString()).willReturn("01/04/2014","02/04/2014","10/04/2014");
		
		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);
		account.printStatement();

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("10/04/2014 | 500.00  | 1400.00");
		verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}

}
