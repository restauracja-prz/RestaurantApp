package pjatk.restaurant.app.service;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.MenuEntity;


@Repository
@Transactional
public class MealTypeDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> findMealTypes() {
		Query query = currentSession().createQuery(
				"select t from MealTypeEntity t");
		return query.list();
	}

}
