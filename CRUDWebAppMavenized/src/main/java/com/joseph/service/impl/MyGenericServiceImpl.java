package com.joseph.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseph.dao.MyGenericDao;
import com.joseph.service.MyGenericService;
@Service
public class MyGenericServiceImpl<E,K extends Serializable> implements MyGenericService<E,K> {
	@Autowired
	private MyGenericDao<E,K> genericDao;
	
	public MyGenericServiceImpl(MyGenericDao<E,K> genericDao) {
        this.genericDao=genericDao;
    }
 
    public MyGenericServiceImpl() {
    }
	
	@Transactional
	public void add(E entity) {
		genericDao.add(entity);
	}

	@Transactional
	public void edit(E entity) {
		genericDao.edit(entity);
	}

	@Transactional
	public void delete(E entity) {
		genericDao.delete(entity);
	}

	@Transactional
	public E get(K id) {
		return genericDao.get(id);
	}

	@Transactional
	public List<E> getAll() {
		return (List<E>) genericDao.getAll();
	}


}
