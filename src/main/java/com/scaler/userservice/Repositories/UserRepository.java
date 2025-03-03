package com.scaler.userservice.Repositories;

import com.scaler.userservice.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user); // Upsert => Update + Insert
    @Override
    Optional<User> findById(Long aLong);
    Optional<User> findByEmail(String email);
    }
