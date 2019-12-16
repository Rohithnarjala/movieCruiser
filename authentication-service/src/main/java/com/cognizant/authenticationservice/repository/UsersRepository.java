package com.cognizant.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
public Users findByUserName(String us_name) throws UsernameNotFoundException;
	
	@Query(nativeQuery=true,value="select count(favorite.ft_id) from moviecruiser.favorite where favorite.ft_us_id=:id")
	public long getFavoriteTotal(int id);
	
}
