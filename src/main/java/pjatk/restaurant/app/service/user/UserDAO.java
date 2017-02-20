package pjatk.restaurant.app.service.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<UserEntity> findAll() {
		return currentSession().createQuery("SELECT u FROM UserEntity u").list();
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
