package com.favour.linktree_backend.user;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "linktree-api/v1/user")
public class UserController {

    private final UserService userService;
    private final SupabaseStorageService supabaseStorageService;

    public UserController(UserService userService, SupabaseStorageService supabaseStorageService) {
        this.userService = userService;
        this.supabaseStorageService = supabaseStorageService;
    }

    @GetMapping
    public String getRoot() {
        return "Successful handshake";
    }

    @GetMapping(path = "{username}") // Get a single user by username
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping // Create a new user
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping(path = "{username}/update-info") // Update user info
    public User updateUserInfo(
            @PathVariable String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String profilePic,
            @RequestParam(required = false) String about,
            @RequestParam(required = false) String password) {
        return userService.updateUserInfo(username, name, email, profilePic, about, password);
    }

    @PostMapping(path = "{username}/update-links") // Update user links
    public User updateUserLinks(@PathVariable String username, @RequestBody List<Link> links) {
        return userService.updateUserLinks(username, links);
    }

    @PostMapping(path = "{username}/update-socials") // Update user socials
    public User updateUserSocials(@PathVariable String username, @RequestBody List<Social> socials) {
        return userService.updateUserSocials(username, socials);
    }

    @PostMapping(path = "{username}/delete-link/{linkId}") // Delete a single link
    public User deleteUserLink(@PathVariable String username, @PathVariable String linkId) {
        return userService.deleteUserLink(username, linkId);
    }

    @PostMapping(path = "{username}/upload-profile-picture")
    public User uploadProfilePicture(@PathVariable String username, @RequestParam("file") MultipartFile file)
            throws IOException {
        String fileName = "avatars/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
        String url = supabaseStorageService.uploadFile(file.getBytes(), fileName, file.getContentType());
        return userService.updateUserProfileImage(username, url);
    }
}
