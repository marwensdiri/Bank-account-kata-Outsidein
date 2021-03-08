package com.bank.junit;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Account;
import com.bank.domain.Transaction;
import com.bank.repositories.TransactionRepository;
import com.bank.service.StatementPrinter;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock StatementPrinter statementPrinter;
	@Mock TransactionRepository transactionRepository;
	private Account account ;	

	@Before
	public void setUp() throws Exception {
		account = new Account(transactionRepository, statementPrinter);		
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

	@Test
	public void print_a_statement() {
        List<Transaction> transactions =  Arrays.asList(new Transaction("01/04/2014",100));
        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();
		verify(statementPrinter).print(transactions);
	}
}
