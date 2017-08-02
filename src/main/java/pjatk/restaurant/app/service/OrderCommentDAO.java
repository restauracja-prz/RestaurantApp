package pjatk.restaurant.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.entity.MenuEntity;

@Repository
@Transactional
public class OrderCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findLastOrderId() {
		Query query = currentSession().createQuery("select o from OrdersEntity o order by o.orderId desc").setMaxResults(1);
		return query.list();
	}
	

}