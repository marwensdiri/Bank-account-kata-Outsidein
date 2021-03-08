package com.bank.domain;

import org.apache.commons.lang3.NotImplementedException;

import com.bank.repositories.TransactionRepository;

public class Account {

	private TransactionRepository transactionRepository;

	public Account(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public void deposit(int amount) {
		transactionRepository.addDeposit(amount);
	}

	public void withdraw(int amount) {
		transactionRepository.addWithdrawal(amount);
	}

	public void printStatement() {
		throw new NotImplementedException("TODO");
	}

}
