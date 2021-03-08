package com.bank.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import java.time.LocalDate;
import org.junit.Test;

import com.bank.service.Clock;


public class DateTest {


	@Test
    public void
    Return_Today_Date_As_String() {

    	Clock clock = new Clock() {
    		@Override
			protected LocalDate today() {
    			return LocalDate.of(2014, 4, 01);   				
    		}
    	};

		String date = clock.todayAsString();
		assertThat(date , is("01/04/2014"));
    }

}