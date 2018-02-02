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
import pjatk.restaurant.app.entity.OrderCommentEntity;

@Repository
@Transactional
public class OrderCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public void insertComment(int orderId, Integer mealQuality, Integer serviceQuickness, Integer serviceQuality, String clientComment){
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
			"INSERT INTO order_rating (order_id, meal_quality, service_quickness, service_quality, client_comment) values (:orderId, :mealQuality, :serviceQuickness, :serviceQuality, :clientComment)");
		query.setParameter("orderId", orderId);
		query.setParameter("mealQuality", mealQuality);
		query.setParameter("serviceQuickness", serviceQuickness);
		query.setParameter("serviceQuality", serviceQuality);
		query.setParameter("clientComment", clientComment);
		query.executeUpdate();
	}
	
@SuppressWarnings("unchecked")
public List<OrderCommentEntity> findOrderComment(int orderId) {
	Query query = currentSession().createQuery(
			"select o from OrderCommentEntity o where o.orderId is :orderId");
	query.setParameter("orderId", orderId);
	return query.list();
}
	
	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findLastOrderId() {
		Query query = currentSession().createQuery("select o from OrdersEntity o order by o.orderId desc").setMaxResults(1);
		return query.list();
	}
	

}