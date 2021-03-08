package com.bank.repositories;

import org.apache.commons.lang3.NotImplementedException;

import com.bank.domain.Transaction;
import com.bank.service.Clock;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

	private List<Transaction> transactions = new ArrayList<Transaction>();
	private Clock clock;

	public TransactionRepository(Clock clock) {
		this.clock = clock;
	}
	
	public void addDeposit(int amount) {
		transactions.add(new Transaction(clock.todayAsString(), amount));

	}
	
	public void addWithdrawal(int amount) {
		throw new NotImplementedException("TODO");

	}
	
	public List<Transaction> allTransactions() {
		return  transactions;
	}
}