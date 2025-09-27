package com.favour.linktree_backend.user;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @SuppressWarnings("null")
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User favour = new User(
                    "Favour",
                    "favour@example.com",
                    "https://example.com/profile.jpg",
                    "Software engineer and content creator.",
                    List.of(
                            new Social("Twitter", "https://twitter.com/favour"),
                            new Social("LinkedIn", "https://linkedin.com/in/favour")),
                    List.of(
                            new Link("Portfolio", "https://favour.dev"),
                            new Link("Blog", "https://blog.favour.dev")),
                    "securepassword123");

            User ayishat = new User(
                    "Ayishat",
                    "ayishat@example.com",
                    "https://example.com/profile.jpg",
                    "Writer and content creator.",
                    List.of(
                            new Social("Twitter", "https://twitter.com/ayishat"),
                            new Social("LinkedIn", "https://linkedin.com/in/ayishat")),
                    List.of(
                            new Link("Portfolio", "https://ayishat.dev"),
                            new Link("Blog", "https://blog.ayishat.dev")),
                    "securepassword123");

            userRepository.saveAll(List.of(favour, ayishat));

        };
    }
}
