package pjatk.restaurant.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pjatk.restaurant.app.entity.TransactionEntity;

@Repository
@Transactional
public class TransactionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<TransactionEntity> findTransactions() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from TransactionEntity o");
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TransactionEntity> findSalesReport(Date dateFrom, Date dateTo) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select o from TransactionEntity o where o.transactionDate >= :dateFrom and o.transactionDate <= :dateTo");
		query.setDate("dateFrom", dateFrom);
		query.setDate("dateTo", dateTo);
		return query.list();
	}
}
