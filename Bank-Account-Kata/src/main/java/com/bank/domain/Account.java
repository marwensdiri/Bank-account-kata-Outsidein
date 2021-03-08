package com.bank.domain;

import org.apache.commons.lang3.NotImplementedException;

import com.bank.repositories.TransactionRepository;
import com.bank.service.StatementPrinter;

public class Account {

	private TransactionRepository transactionRepository;
	private StatementPrinter statementPrinter;
	
	public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
		this.transactionRepository = transactionRepository;
		this.statementPrinter = statementPrinter;
	}

	public void deposit(int amount) {
		transactionRepository.addDeposit(amount);
	}

	public void withdraw(int amount) {
		transactionRepository.addWithdrawal(amount);
	}

	public void printStatement() {
		statementPrinter.print(transactionRepository.allTransactions());
	}

}
