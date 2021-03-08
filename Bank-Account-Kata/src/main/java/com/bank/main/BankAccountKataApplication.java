package com.bank.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.domain.Account;
import com.bank.repositories.TransactionRepository;
import com.bank.service.Clock;
import com.bank.service.Console;
import com.bank.service.StatementPrinter;

@SpringBootApplication
public class BankAccountKataApplication {

	public static void main(String[] args) {
		Clock clock = new Clock();
		TransactionRepository transactionRepository = new TransactionRepository(clock );
		Console console = new Console();
		StatementPrinter statementPrinter = new StatementPrinter(console );
		Account account = new Account(transactionRepository , statementPrinter ); 

		account.deposit(1000);
		account.withdraw(400);
		account.withdraw(1200);
		account.printStatement();
	}

}
