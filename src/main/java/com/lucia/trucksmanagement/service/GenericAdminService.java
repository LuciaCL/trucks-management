package com.lucia.trucksmanagement.service;

import java.io.Serializable;
import java.util.List;

import com.lucia.trucksmanagement.persistence.dao.Identifiable;

public interface GenericAdminService<E extends Identifiable<K>, K extends Serializable> {

	public void create(E entity);
	
	public E find(K id);
	
	public void update(E entity);
	
	public void remove(K id);
	
	public List<E> findAll();
	
}
