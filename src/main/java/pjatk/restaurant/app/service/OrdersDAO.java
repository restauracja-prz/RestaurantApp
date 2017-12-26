package pjatk.restaurant.app.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrderStatus;
import pjatk.restaurant.app.entity.OrdersEntity;

@Repository
@Transactional
public class OrdersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findOrders() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrdersEntity o");
		
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
	public List<OrdersEntity> findOrderAndStatusReport(Date dateFrom, Date dateTo) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrdersEntity o where o.orderDate >= :dateFrom and o.orderDate <= :dateTo");
		query.setDate("dateFrom", dateFrom);
		query.setDate("dateTo", dateTo);
		return query.list();
	}
	
	
	public void submitOrder(int orderId, BigDecimal sum, String userId) {
		System.out.println("ORDER STATUS "+OrderStatus.NEW);
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"INSERT INTO orders (order_id, order_date, order_status, order_price_sum, user_id, waiter_need) "
				+ "values (:orderId, NOW(), :order_status, :order_price_sum, :userId, 0)");
		query.setParameter("orderId", orderId);
		
		query.setParameter("order_status", OrderStatus.NEW.name());
		query.setParameter("order_price_sum", sum);
		query.setParameter("userId", userId);
		query.executeUpdate();
		
		
	}
	
	public void submitOrderWaiterNeed(int orderId, BigDecimal sum, String userId, boolean waiterNeed ) {
		System.out.println("ORDER STATUS "+OrderStatus.NEW);
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"INSERT INTO orders (order_id, order_date, order_status, order_price_sum, user_id, waiter_need) "
				+ "values (:orderId, NOW(), :order_status, :order_price_sum, :userId, :waiterNeed)");
		query.setParameter("orderId", orderId);
		query.setParameter("waiterNeed", waiterNeed ? 1 : 0);
		query.setParameter("order_status", OrderStatus.NEW.name());
		query.setParameter("order_price_sum", sum);
		query.setParameter("userId", userId);
		query.executeUpdate();
		
		
	}
	
	public void updateOrderWaiterNeed(int orderId, BigDecimal sum, String userId, boolean waiterNeed ) {
		System.out.println("update waiter");

		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		OrdersEntity ord = findOrderById(orderId);
		ord.setWaiterNeed(false);
		sess.saveOrUpdate(ord);
		tx.commit();
		sess.close();



	}

	@SuppressWarnings("unchecked")
	public List<MenuEntity> mealOrder(int menuId) {
		Query query = currentSession().createQuery("select m from MenuEntity m join fetch m.mealTranslation where m.isVisible = 'Y' and m.menuId is :menuId");
		query.setInteger("menuId", menuId);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findLastOrderId() {
		Query query = currentSession().createQuery("select o from OrdersEntity o order by o.orderId desc").setMaxResults(1);
		return query.list();
	}
	
	
	public OrdersEntity findOrderById(int orderId) {
		return (OrdersEntity) currentSession().get(OrdersEntity.class, orderId);
	}

	@SuppressWarnings("unchecked")
	public void save(OrdersEntity entity) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(entity);
		tx.commit();
		sess.close();
				
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findOrdersByStatus(OrderStatus status) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrdersEntity o where o.orderStatus = :status");
		query.setString("status", status.toString());
		return query.list();
				
	}
	
}
