package pjatk.restaurant.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrdersEntity;

@Repository
@Transactional
public class OrdersDAO {

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

}
