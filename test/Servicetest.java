package com.erpbackend;

import java.sql.SQLException;
import java.util.List;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.erpbackend.production.Repository;
import com.erpbackend.production.Service;

@ExtendWith(MockitoExtension.class)
public class Servicetest {
	
	@Mock
	Repository repository;
	
	@InjectMocks
	Service service;
	
	@Test
	void testSuccess() {
		try {
			Mockito.when(repository.getStuff()).thenReturn(Arrays.asList("A","B", "CDEFGHIJK", "12345", "1234"));
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		List<String> stuff=service.getStuffWithLengthLessThanFive();
		
		Assertions.assertNotNull(stuff);
		Assertions.assertEquals(3, stuff.size());
	}
	
	@Test
	void testException() {
		try {
			Mockito.when(repository.getStuff()).thenThrow(new SQLException("Connection exception"));
			
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		// Execute the service that uses the mocked repository
        List<String> stuff = service.getStuffWithLengthLessThanFive();

        // Validate the response
        Assertions.assertNotNull(stuff);
        Assertions.assertEquals(0, stuff.size());
	}
	

}
