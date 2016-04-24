package com.joseph.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joseph.dao.MyGenericDao;

@Repository
@SuppressWarnings("unchecked")
public abstract  class MyGenericDaoImpl<E,K extends Serializable> implements MyGenericDao<E,K> {
	@Autowired
	private SessionFactory session;
	
	protected Class<? extends E> daoType;
	
	public MyGenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        daoType = (Class) genericSuperclass.getActualTypeArguments()[0];

    }
	
	protected Session currentSession() {
	      return session.getCurrentSession();
	}
	
	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void edit(E entity) {
		currentSession().update(entity);
	}

	@Override
	public void delete(E entity) {		
		currentSession().delete(entity);
	}

	@Override
	public E get(K id) {
	return (E)currentSession().get(daoType, id);
	}

	@Override
	public List<E> getAll() {
		final Criteria crit = currentSession().createCriteria(daoType);
	    return crit.list();
	}

}
