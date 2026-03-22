package com.kasiakab.dockernetworkingdemo.controller;

import com.kasiakab.dockernetworkingdemo.model.UserProfile;
import com.kasiakab.dockernetworkingdemo.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileRepository repository;


    @GetMapping("/get-profile")
    public ResponseEntity<UserProfile> getProfile() {
        return repository.findByUserid(1)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(new UserProfile()));
    }

    @PostMapping("/update-profile")
    public ResponseEntity<UserProfile> updateProfile(@RequestBody UserProfile incoming) {
        UserProfile profile = repository.findByUserid(1)
                .orElse(new UserProfile());

        profile.setUserid(1);
        if (incoming.getName() != null) profile.setName(incoming.getName());
        if (incoming.getEmail() != null) profile.setEmail(incoming.getEmail());
        if (incoming.getInterests() != null) profile.setInterests(incoming.getInterests());

        return ResponseEntity.ok(repository.save(profile));
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("User-service is up and running!");
    }
}