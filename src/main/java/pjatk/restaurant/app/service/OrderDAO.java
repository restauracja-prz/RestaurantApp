package pjatk.restaurant.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.OrdersEntity;
import pjatk.restaurant.app.entity.MenuEntity;

@Repository
@Transactional
public class OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
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
}

