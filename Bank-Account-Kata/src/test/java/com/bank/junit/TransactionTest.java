package com.bank.junit;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bank.domain.Transaction;
import com.bank.repositories.TransactionRepository;
import com.bank.service.Clock;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

	@Mock Clock clock;
	private static final String TODAY = "01/04/2014";
	private TransactionRepository transactionRepository;
	private List<Transaction> transactions;

	@Before
	public void setUp() throws Exception {
		transactionRepository = new TransactionRepository(clock);
	}

    @Test
    public void
    store_a_deposit_transaction() { 	
    	given(clock.todayAsString()).willReturn(TODAY);	
    	transactionRepository.addDeposit(100);

    	transactions =  transactionRepository.allTransactions();	

    	assertThat(transactions.size(), is(1));
    	assertThat(transactions.get(0), is(new Transaction(TODAY,100)));


    }
    
    @Test
    public void
    store_a_withdrawal_transaction() { 	
    	given(clock.todayAsString()).willReturn(TODAY);	
    	transactionRepository.addWithdrawal(100);;

    	transactions =  transactionRepository.allTransactions();	

    	assertThat(transactions.size(), is(1));
    	assertThat(transactions.get(0), is(new Transaction(TODAY,-100)));    	
    }

}
