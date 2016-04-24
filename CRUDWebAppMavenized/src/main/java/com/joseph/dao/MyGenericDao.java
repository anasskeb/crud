package com.joseph.dao;

import java.util.List;

public interface MyGenericDao<E,K> {
	public void add(E entity);
	public void edit(E entity);
	public void delete(E entity);
	public E get(K key);
	public List<E> getAll();
}
