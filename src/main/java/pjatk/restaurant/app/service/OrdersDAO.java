package pjatk.restaurant.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrderStatus;
import pjatk.restaurant.app.entity.OrdersEntity;

@Repository
@Transactional
public class OrdersDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
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
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findOrdersByStatus(OrderStatus status) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrdersEntity o where o.orderStatus = :status");
		query.setString("status", status.toString());
		return query.list();
				
	}
	
	@SuppressWarnings("unchecked")
	public OrdersEntity findOrderById(int ig) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrdersEntity o where o.orderId=:id");
		query.setInteger("id", ig);
		return (OrdersEntity)query.uniqueResult();
				
	}
	
	@SuppressWarnings("unchecked")
	public void save(OrdersEntity entity) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(entity);
		tx.commit();
		sess.close();
				
	}

}
