package com.sumaia.CURD.repositories;


import com.sumaia.CURD.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

