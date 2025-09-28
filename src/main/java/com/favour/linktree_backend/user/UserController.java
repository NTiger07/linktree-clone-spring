package com.favour.linktree_backend.user;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRoot() {
        return "Successful handshake"; // delegates to service
    }

    @GetMapping(path = "{userId}") // Get a single user by id
    public User getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping // Create a new user
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping(path = "{userId}/update-info") // Update user info
    public User updateUserInfo(
            @PathVariable String userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String profilePic,
            @RequestParam(required = false) String about,
            @RequestParam(required = false) String password) {
        return userService.updateUserInfo(userId, username, name, email, profilePic, about, password);
    }

    @PostMapping(path = "{userId}/update-links") // Update user links
    public User updateUserLinks(@PathVariable String userId, @RequestBody List<Link> links) {
        return userService.updateUserLinks(userId, links);
    }

    @PostMapping(path = "{userId}/update-socials") // Update user socials
    public User updateUserSocials(@PathVariable String userId, @RequestBody List<Social> socials) {
        return userService.updateUserSocials(userId, socials);
    }

    @PostMapping(path = "{userId}/delete-link/{linkId}") // Delete a single link
    public User deleteUserLink(@PathVariable String userId, @PathVariable String linkId) {
        return userService.deleteUserLink(userId, linkId);
    }

}
