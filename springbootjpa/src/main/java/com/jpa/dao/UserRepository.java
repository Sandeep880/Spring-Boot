package com.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.jpa.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String city);
	
	public List<User> findByNameOrCity(String name,String city);

}
