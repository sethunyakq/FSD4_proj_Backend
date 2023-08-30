package com.example.FSD4RestAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    // You can add custom query methods if needed
	AppUser  findByEmail(String email);
	    // You can add other custom query methods if needed
}
