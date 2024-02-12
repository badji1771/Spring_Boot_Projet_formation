package com.orderprocessing.order.bo;

import java.sql.SQLException;

import com.orderprocessing.order.bo.exception.BOException;
import com.orderprocessing.order.dto.Order;

public interface OrderBOService {
	
	 boolean placeOrder(Order order) throws BOException;
	 boolean cancelOrder(int id) throws BOException;
	 boolean deleteOrder(int id) throws BOException;

}
