package com.favour.linktree_backend.user;

import java.util.Objects;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("null")
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (user.getUsername() != null && userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("Username taken");
        }
        if (user.getEmail() != null && userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        // You may want to hash the password before saving
        return userRepository.save(user);
    }

    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "User does not exist"));
        return user;
    }

    // Delete a single link from user's links by linkId
    public User deleteUserLink(String userId, String linkId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        List<Link> links = user.getLinks();
        if (links != null) {
            links.removeIf(link -> link.getId().equals(linkId));
            user.setLinks(links);
        }
        return userRepository.save(user);
    }

    // Update user info (username, name, email, profilePic, about, password)
    public User updateUserInfo(String userId, String username, String name, String email, String profilePic,
            String about, String password) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));

        if (username != null && !username.isEmpty() && !Objects.equals(user.getUsername(), username)) {
            Optional<User> userOptional = userRepository.findByUsername(username);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("Username taken");
            }
            user.setUsername(username);
        }

        if (name != null && !name.isEmpty() && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            user.setEmail(email);
        }

        if (profilePic != null && !profilePic.isEmpty() && !Objects.equals(user.getProfilePic(), profilePic)) {
            user.setProfilePic(profilePic);
        }

        if (about != null && !about.isEmpty() && !Objects.equals(user.getAbout(), about)) {
            user.setAbout(about);
        }

        if (password != null && !password.isEmpty()) {
            // You may want to hash the password before saving
            user.setPassword(password);
        }

        return userRepository.save(user);
    }

    // Update user links
    public User updateUserLinks(String userId, List<Link> links) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setLinks(links);
        return userRepository.save(user);
    }

    // Update user socials
    public User updateUserSocials(String userId, List<Social> socials) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setSocials(socials);
        return userRepository.save(user);
    }

}
