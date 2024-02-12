package com.orderprocessing;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.orderprocessing.order.bo.OrderBOServiceImpl;
import com.orderprocessing.order.bo.exception.BOException;
import com.orderprocessing.order.dao.OrderDAO;
import com.orderprocessing.order.dto.Order;

@SpringBootTest
class OrderProcessingServiceApplicationTests {
	
	private static final int ORDER_ID = 123;
	@MockBean
	OrderDAO dao;
	private OrderBOServiceImpl bo;
	
	@BeforeEach
	public void setup() {
		bo=new OrderBOServiceImpl();
		bo.setDao(this.dao);
	}
//	@Test
//	public void test() {
//		
//	}
	
	@Test
	 void placeOrder_Should_Create_An_Orde() throws SQLException,BOException{
			Order order = new Order();
			when(dao.create(order)).thenReturn(1);
			
			boolean result = bo.placeOrder(order);
			assertTrue(result);
			
			verify(dao).create(order);
	}
	
	@Test
	void placeOrder_Should_Throw_BOException() throws SQLException,BOException{
		
		Order order = new Order();
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);//on creer ici une exception
		
		assertThrows(BOException.class, ()->bo.placeOrder(order));//ici on verifie si l'exception est bien lever
		
		verify(dao).create(order);
	}
	
	@Test
	void cancelOrder_Should_Cancel_The_Order() throws SQLException,BOException{
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		when(dao.read(order.getId())).thenReturn(order);
		when(dao.update(order)).thenReturn(123);
		
		boolean result = bo.cancelOrder(order.getId());
		assertTrue(result);
		
		verify(dao).read(order.getId());
		verify(dao).update(order);
		
	}
	
	
	

	@Test
	void cancelOrder_Should_NOT_Cancel_The_Order() throws SQLException,BOException{
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		when(dao.read(order.getId())).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		
		boolean result = bo.cancelOrder(order.getId());
		assertFalse(result);
		
		verify(dao).read(order.getId());
		verify(dao).update(order);
		
	}
	
	@Test
	void deleteOrder_Delete_The_Order() throws SQLException,BOException{
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		when(dao.delete(order.getId())).thenReturn(1);
		
		boolean result = bo.deleteOrder(order.getId());
		assertTrue(result);
		
		verify(dao).delete(order.getId());
	}

}
