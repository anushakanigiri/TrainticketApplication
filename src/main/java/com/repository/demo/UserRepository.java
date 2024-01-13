package com.repository.demo;

import java.util.Optional;

import com.entity.demo.User;

public interface UserRepository {
	Optional<User> findByEmailAddress(String emailAddress);

    void save(User user);
}


