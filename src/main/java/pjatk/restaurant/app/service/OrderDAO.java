package pjatk.restaurant.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.service.entity.OrderEntity;

@Repository
@Transactional
public class OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<OrderEntity> findOrderEntity() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from OrderEntity o");
		
		return query.list();
	}
}
