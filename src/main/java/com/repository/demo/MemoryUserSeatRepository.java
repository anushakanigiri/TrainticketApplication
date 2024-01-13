package com.repository.demo;

import java.util.*;

import com.entity.demo.User;
import com.entity.demo.UserSeat;

public class MemoryUserSeatRepository implements UserSeatRepository {
	private final List<UserSeat> userSeats = new ArrayList<>();

	

	@Override
	public List<UserSeat> findBySection(String section) {
		return userSeats.stream()
                .filter(userSeat -> userSeat.getSeat().startsWith(section))
                .toList();
		}

	@Override
	public void save(UserSeat userSeat) {
		userSeats.add(userSeat);
		}

	@Override
	public void remove(String emailAddress) {
		userSeats.removeIf(userSeat -> userSeat.getUser().getEmailAddress().equals(emailAddress));
		}

	@Override
	public Optional<UserSeat> findByUser(User user) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void remove(User user) {
		userSeats.removeIf(userSeat -> userSeat.getUser().equals(user));
		
	}

}
