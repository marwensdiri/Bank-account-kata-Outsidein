package com.bank.junit;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Account;
import com.bank.repositories.TransactionRepository;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {


	@Mock TransactionRepository transactionRepository;
	private Account account ;	

	@Before
	public void setUp() throws Exception {
		account = new Account(transactionRepository);		
	}

	@Test
	public void store_a_deposit_transaction() {
		account.deposit(100);
		verify(transactionRepository).addDeposit(100);
	}
	
	public void store_a_withdrawl_transaction() {
		account.withdraw(100);
		verify(transactionRepository).addWithdrawal(100);
	}

}
