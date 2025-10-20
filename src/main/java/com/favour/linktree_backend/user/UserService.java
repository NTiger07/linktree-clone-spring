package com.favour.linktree_backend.user;

import java.util.Objects;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@SuppressWarnings("null")
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        if (user.getUsername() != null && userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("Username taken");
        }
        if (user.getEmail() != null && userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalStateException(
                "User does not exist"));
        return user;
    }

    // Delete a single link from user's links by linkId
    public User deleteUserLink(String username, String linkId) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        List<Link> links = user.getLinks();
        if (links != null) {
            links.removeIf(link -> link.getId().equals(linkId));
            user.setLinks(links);
        }
        return userRepository.save(user);
    }

    // Update user info (username, name, email, profilePic, about, password)
    public User updateUserInfo(String username, String name, String email, String profilePic,
            String about, String password) {
        User user = userRepository.findByUsername(username)
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
            user.setPassword(passwordEncoder.encode(password));
        }

        return userRepository.save(user);
    }

    // Update user profilePic
    public User updateUserProfileImage(String username, String url) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setProfilePic(url);
        return userRepository.save(user);
    }

    // Update user links
    public User updateUserLinks(String username, List<Link> links) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setLinks(links);
        return userRepository.save(user);
    }

    // Update user socials
    public User updateUserSocials(String username, List<Social> socials) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setSocials(socials);
        return userRepository.save(user);
    }

}
