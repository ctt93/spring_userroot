package com.dao;

import java.util.List;








import javax.annotation.Resource;
import javax.annotation.Resources;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.model.Pager;
import com.model.SystemContext;
import com.model.User;

@Repository("userDao")
public class UserDao extends HibernateDaoSupport implements IUserDao {
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		System.out.println("执行了update");
		this.getHibernateTemplate().update(user);
		this.getHibernateTemplate().flush();
	}

	@Override
	public void delete(int id) {
		User user = this.load(id);
		this.getHibernateTemplate().delete(user);
		this.getHibernateTemplate().flush();
		System.out.println("真的执行了删除");
	
	}

	@Override
	public User load(int id) {
		System.out.println("执行了UserDao中的load");
		return this.getHibernateTemplate().load(User.class, id);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return this.getSession().createQuery("from User").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		List<User> datas = query.list();
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (long)this.getSession()
				.createQuery("select count(*) from User")
				.uniqueResult();
		us.setTotal(total);
		return us;
	}

	@Override
	public User loadByUsername(String username) {
		return (User)this.getSession().createQuery("from User where username=?")
				.setParameter(0, username).uniqueResult();
	}

}
