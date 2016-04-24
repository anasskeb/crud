package com.joseph.service;

import java.util.List;

public interface MyGenericService<E,K> {
	public void add(E entity);
	public void edit(E entity);
	public void delete(E entity);
	public E get(K key);
	public List<E> getAll();
}
