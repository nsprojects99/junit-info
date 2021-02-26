package com.erpbackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.erpbackend.production.Widget;
import com.erpbackend.production.WidgetRepository;
import com.erpbackend.production.WidgetService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class WidgetServiceTest {
	
	@Autowired
	private WidgetService service;
	
	@MockBean
	private WidgetRepository repository;
	
	@Test
	@DisplayName("Test findbyId success")
	void testfindByID() {
		
		Widget widget= new Widget(1l,"Widget Name", "Description", 1);
		doReturn(Optional.of(widget)).when(repository).findById(1l);
		
		Optional<Widget> returnedWidget=service.findById(1l);
		
		 Assertions.assertTrue(returnedWidget.isPresent(), "Widget was not found");
	        Assertions.assertSame(returnedWidget.get(), widget, "The widget returned was not the same as the mock");
		
	}
	@Test
	@DisplayName("Test findById Not Found")
	void testfindByIdNotFound() {
		
		doReturn(Optional.empty()).when(repository.findById(1l));
		
		Optional<Widget> returnedWidget= service.findById(1l);
		
		Assertions.assertFalse(returnedWidget.isPresent(),"Widget should not be found");	
	}
	

}
