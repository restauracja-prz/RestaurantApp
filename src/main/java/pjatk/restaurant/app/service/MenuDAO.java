package pjatk.restaurant.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.service.entity.MenuEntity;
import pjatk.restaurant.app.service.entity.UserEntity;

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
	
	public void menuSave(MenuEntity menu) {
		currentSession().save(menu.getMealTranslation());
		currentSession().save(menu);
	}
	
	public List<MenuEntity> findFullMenu() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select m from MenuEntity m join fetch m.mealTranslation");
		
		return query.list();
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void mealDisable(int mealId) {
		Query query = currentSession().createQuery("UPDATE MenuEntity m SET m.isVisible='N' where m.mealId is :mealId");
		query.setInteger("mealId", mealId);
		query.executeUpdate();
	}
	
	public void mealEnable(int mealId) {
		Query query = currentSession().createQuery("UPDATE MenuEntity m SET m.isVisible='Y' where m.mealId is :mealId");
		query.setInteger("mealId", mealId);
		query.executeUpdate();
	}

}
