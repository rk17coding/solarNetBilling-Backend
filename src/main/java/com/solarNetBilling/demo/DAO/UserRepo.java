package com.solarNetBilling.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solarNetBilling.demo.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	Users findByUsername(String username);
}