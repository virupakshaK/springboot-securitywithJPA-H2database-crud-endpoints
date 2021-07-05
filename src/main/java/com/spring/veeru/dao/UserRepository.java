package com.spring.veeru.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.veeru.models.User;

/**
 * @author virupaksha.kuruva
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByUserName(String userName);
}
