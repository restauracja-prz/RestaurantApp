package pjatk.restaurant.app.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrderEntity;

@Repository
@Transactional
public class OrdersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<OrderEntity> findOrders() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrderEntity o");
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetailsEntity> findOrderDetailsReport(Date dateFrom, Date dateTo) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrderDetailsEntity o where o.timestamp >= :dateFrom and o.timestamp <= :dateTo");
		query.setDate("dateFrom", dateFrom);
		query.setDate("dateTo", dateTo);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderEntity> findOrderAndStatusReport(Date dateFrom, Date dateTo) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrderEntity o where o.orderDate >= :dateFrom and o.orderDate <= :dateTo");
		query.setDate("dateFrom", dateFrom);
		query.setDate("dateTo", dateTo);
		return query.list();
	}
	
	
	public void submitOrder(int orderId, BigDecimal sum, String userId) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"INSERT INTO orders (order_id, order_date, order_status, order_price_sum, user_id) values (:orderId, NOW(), :order_status, :order_price_sum, :userId)");
		query.setParameter("orderId", orderId);
		query.setParameter("order_status", "NEW");
		query.setParameter("order_price_sum", sum);
		query.setParameter("userId", userId);
		query.executeUpdate();
		
		
	}

}
