package com.villarruel.mangas.service;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MangaUserService implements UserDetailsService {
    // Para definir el user y password
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("ismael", "{noop}SM77794261", new ArrayList<>());
    }
}