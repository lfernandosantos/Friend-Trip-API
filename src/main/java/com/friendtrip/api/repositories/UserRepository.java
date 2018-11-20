package com.friendtrip.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.friendtrip.api.entities.User;


@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByFacebookID(String facebookId);

}
