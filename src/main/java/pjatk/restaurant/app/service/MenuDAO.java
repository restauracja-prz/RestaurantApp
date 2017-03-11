package pjatk.restaurant.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.service.entity.MenuEntity;

@Repository
@Transactional
public class MenuDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public List<MenuEntity> findVisibleMenu() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select m from MenuEntity m join fetch m.mealTranslation where m.isVisible = 'Y'");
		
		return query.list();
		
	}

}
