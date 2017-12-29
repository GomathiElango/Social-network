package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SocialNetworkBackEnd.Model.Blog;
//import com.SocialNetworkBackEnd.Model.forum;
import com.SocialNetworkBackEnd.Model.Forum;

@Repository
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired 
	SessionFactory sessionfactory;
  public ForumDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionfactory=sessionFactory;
	}

  @Transactional
	//@Override
	public boolean addforum(Forum forum) 
	{
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			session.save(forum);
			transaction.commit();
			session.close();
			/*System.out.println("1");
		    System.out.println(sessionfactory);

			sessionfactory.getCurrentSession().save(user);*/
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Transactional
	public Forum getforumbyid(int forumId) 
	{
		
	    Session session=sessionfactory.openSession();
	    Transaction transaction=session.getTransaction();
	    transaction.begin();
	    Forum b=session.get(Forum.class,new Integer(forumId));
	       session.flush();
	       transaction.commit();
	       session.close();
		return b;
		 
	}
@Transactional
public boolean updateforum(Forum b)
{
try
	{
	 Session session=sessionfactory.openSession();
	Transaction transaction=session.getTransaction();
	transaction.begin(); 
	session.saveOrUpdate(b);
   session.flush();
   transaction.commit();
	 
   session.close();
	 System.out.println("updated successfully");
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;	
}
}
@Transactional
public boolean deleteforum(Forum b)
{
try
	{
	Session session=sessionfactory.openSession();
	Transaction transaction=session.getTransaction();
	transaction.begin();
	session.delete(b);
	session.flush();
	transaction.commit();
	session.close();
	 System.out.println("deleted successfully");
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;	
}
}
@Transactional
public List<Forum> getallforums()
{
	Session session=sessionfactory.openSession();
	Transaction transaction=session.getTransaction();
	transaction.begin();
	Query query=session.createQuery("from Forum");
	//System.out.println("****"+query);
	List<Forum> fdetail=query.list();
	
	//List<UserDetail> userdetail=session.createQuery("from UserDetail").list();
//	System.out.println("@@:"+userdetail);
    
	//session.close();
    return fdetail;
}
@Transactional
public boolean approveforum(Forum b)
{
	try
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin(); 
		session.saveOrUpdate(b);
 		 session.flush();
 	     transaction.commit();
 		 session.close();
//	sessionfactory.getCurrentSession().saveOrUpdate(b);
	System.out.println("appoved forum");
	return true;
}
	catch(Exception e)
	{
		System.out.println(e);
		return false;	
	}
}
@Transactional
public boolean rejectforum(Forum b) {
	try
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin(); 
		session.saveOrUpdate(b);
      // transaction.commit();
		 session.flush();
	     transaction.commit();
		 session.close();
	//sessionfactory.getCurrentSession().saveOrUpdate(b);
	System.out.println("rejected forum");
	return true;
}
	catch(Exception e)
	{
		System.out.println(e);
		return false;	
	}
}

}
