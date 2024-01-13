package com.repository.demo;

import java.util.Optional;
import java.util.*;

import com.entity.demo.User;

public class MemoryUserRepository implements UserRepository {
	private final Map<String, User> users = new HashMap<>();

	

	@Override
	public Optional<User> findByEmailAddress(String emailAddress) {

		return Optional.ofNullable(users.get(emailAddress));
	}

	@Override
	public void save(User user) {
		
		users.put(user.getEmailAddress(), user);

	}

}
