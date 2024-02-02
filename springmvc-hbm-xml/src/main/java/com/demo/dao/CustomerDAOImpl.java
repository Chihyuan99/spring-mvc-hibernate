package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Customer> viewAll() {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		
		return list;
	}

	public void saveCustomer(Customer customer) {
		System.out.println("IN DAO: " + customer);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();

	}

	
	public Customer getCustomerById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;

	}

	
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.byId(Customer.class).load(id);
		//Transaction tx = session.beginTransaction(); 
		session.delete(customer);
		//tx.commit();

	}

}
