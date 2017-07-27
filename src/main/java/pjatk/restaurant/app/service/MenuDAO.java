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
public class MenuDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> findVisibleFilteredMenu() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select m from MenuEntity m join fetch m.mealTranslation r join fetch m.mealType t where m.isVisible = 'Y'");
		return query.list();	
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> findVisibleMenu() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select m from MenuEntity m join fetch m.mealTranslation where m.isVisible = 'Y'");
		
		return query.list();	
	}
	
	public void menuSaveOrUpdate(MenuEntity menu) {
		currentSession().saveOrUpdate(menu.getMealTranslation());
		currentSession().saveOrUpdate(menu);
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuEntity> findFullMenu() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select m from MenuEntity m join fetch m.mealTranslation");
		
		return query.list();
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void mealDisable(int menuId) {
		Query query = currentSession().createQuery("UPDATE MenuEntity m SET m.isVisible='N' where m.menuId is :menuId");
		query.setInteger("menuId", menuId);
		query.executeUpdate();
	}
	
	public void mealEnable(int menuId) {
		Query query = currentSession().createQuery("UPDATE MenuEntity m SET m.isVisible='Y' where m.menuId is :menuId");
		query.setInteger("menuId", menuId);
		query.executeUpdate();
	}

	public MenuEntity findMenuById(Long mealId) {
		return (MenuEntity) currentSession().get(MenuEntity.class, mealId);
	}
}
