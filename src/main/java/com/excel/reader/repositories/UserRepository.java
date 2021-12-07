package com.excel.reader.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excel.reader.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
