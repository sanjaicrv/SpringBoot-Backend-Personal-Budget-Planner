package com.example.Personal.Budget.Planner.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa extends JpaRepository<UserEntity, Long>{

}
