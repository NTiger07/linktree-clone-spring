package com.favour.linktree_backend.user;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // Optional<User> findByGoogleId(String googleId);
}
