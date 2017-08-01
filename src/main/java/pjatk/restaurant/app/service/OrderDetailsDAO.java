package pjatk.restaurant.app.service;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import pjatk.restaurant.app.entity.MenuEntity;
import pjatk.restaurant.app.entity.OrderDetailsEntity;
import pjatk.restaurant.app.entity.OrdersEntity;

@Repository
@Transactional
public class OrderDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public void insertOrderDetails(List<MenuEntity> orderedMeals, int orderId){
		for (MenuEntity m : orderedMeals) {
			Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"INSERT INTO order_details (order_id, menu_id, unit_price, timestamp) values (:orderId, :menuId, :unitPrice, now())");
			query.setParameter("orderId", orderId);
			query.setParameter("menuId", m.getMenuId());
			query.setParameter("unitPrice", m.getUnitPrice());
			query.executeUpdate();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrderDetailsEntity> findOrderDetails(){
		Query query = sessionFactory.getCurrentSession().createQuery("select d from OrderDetailsEntity d join fetch d.order o join fetch d.menu m join fetch m.mealTranslation");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetailsEntity> findUserOrderDetails(String userId){
		Query query = sessionFactory.getCurrentSession().createQuery("select d from OrderDetailsEntity d join fetch d.order o join fetch d.menu m join fetch m.mealTranslation where o.userId is :userId and o.orderStatus not like :orderStatus");
		query.setParameter("orderStatus", "closed");
		query.setParameter("userId", userId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<OrdersEntity> findUserOrders(String userId){
		Query query = sessionFactory.getCurrentSession().createQuery("select o from OrdersEntity o where o.userId is :userId and o.orderStatus not like 'closed'");
		query.setParameter("userId", userId);
		return query.list();
	}
	
}
