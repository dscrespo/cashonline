package com.example.cashonline.persistence.repository;

import com.example.cashonline.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
