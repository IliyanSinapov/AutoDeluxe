package com.iliyan.autodeluxe.repository;

import com.iliyan.autodeluxe.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}