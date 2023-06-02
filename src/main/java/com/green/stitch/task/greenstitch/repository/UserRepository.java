package com.green.stitch.task.greenstitch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.green.stitch.task.greenstitch.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
