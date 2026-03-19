package com.kasiakab.dockernetworkingdemo.repository;

import com.kasiakab.dockernetworkingdemo.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    Optional<UserProfile> findByUserid(Integer userid);
}
