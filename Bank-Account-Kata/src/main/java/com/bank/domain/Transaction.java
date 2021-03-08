package com.bank.domain;

import org.apache.commons.lang3.NotImplementedException;

public class Transaction {

	private final String today;
	private final int amount;

	public Transaction(String today, int amount) {
		this.today = today;
		this.amount = amount;
	}

	public String getToday() {
		return today;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((today == null) ? 0 : today.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (today == null) {
			if (other.today != null)
				return false;
		} else if (!today.equals(other.today))
			return false;
		return true;
	}
}
