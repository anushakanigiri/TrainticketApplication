package com.repository.demo;

import java.util.List;
import java.util.Optional;

import com.entity.demo.User;
import com.entity.demo.UserSeat;

public interface UserSeatRepository {
	List<UserSeat> findBySection(String section);

    
    Optional<UserSeat> findByUser(User user);
    void save(UserSeat userSeat);
    void remove(User user);

    void remove(String emailAddress);
    
}

