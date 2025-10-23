package com.favour.linktree_backend.user;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfig {
        @SuppressWarnings("null")

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        @Bean
        CommandLineRunner commandLineRunner(UserRepository userRepository) {
                return args -> {
                        User favour = new User(
                                        "favour",
                                        "Favour",
                                        "favour@example.com",
                                        "https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/avatars/avatar-dafault.png",
                                        "Software engineer and content creator.",
                                        List.of(
                                                        new Social("Twitter", "https://twitter.com/favour"),
                                                        new Social("LinkedIn", "https://linkedin.com/in/favour")),
                                        List.of(
                                                        new Link("https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/link-images/link-default.png", "Portfolio", "https://favour.dev", 1, true),
                                                        new Link("https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/link-images/link-default.png", "Blog", "https://blog.favour.dev", 2, true)),
                                        passwordEncoder.encode("securepassword123"));

                        User ayishat = new User(
                                        "keks",
                                        "Ayishat",
                                        "ayishat@example.com",
                                        "https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/avatars/avatar-dafault.png",
                                        "Writer and content creator.",
                                        List.of(
                                                        new Social("Twitter", "https://twitter.com/ayishat"),
                                                        new Social("LinkedIn", "https://linkedin.com/in/ayishat")),
                                        List.of(
                                                        new Link("https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/link-images/link-default.png", "Portfolio", "https://ayishat.dev", 1, true),
                                                        new Link("https://vwzciaaeijiwhnvlfzni.supabase.co/storage/v1/object/public/user-avatars/link-images/link-default.png", "Blog", "https://blog.ayishat.dev", 2, true)),
                                        passwordEncoder.encode("securepassword123"));

                        userRepository.saveAll(List.of(favour, ayishat));

                };
        }
}
