package com.ydel.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ydel.model.User;
import com.ydel.util.HibernateUtil;

public class UserDAOImpl implements UserDao {

	public void saveUser(User user) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			transaction = session.beginTransaction();
					session.save(user);
					transaction.commit();
			
		}
		catch (Exception e) {
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		
	}

}
