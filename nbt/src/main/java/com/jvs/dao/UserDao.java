package com.jvs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jvs.entity.User;

public interface UserDao  extends CrudRepository<User, Integer>  {
	@Query("select count(u) from User u")
	public long getCountOfUsers();
	
	@Query("select u from User u where u.username=:username and u.password=:password and roles=:role")
	public User getUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password, @Param("role") String role);
	
	@Query("select u from User u where u.username=:username")
	public User getUserByUserName(@Param("username") String username);
	

}
