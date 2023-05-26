package com.denilsson.springsecurity.customlogin.service;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.denilsson.springsecurity.customlogin.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    HashMap<String, CustomUser> userStore = new HashMap<>();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(CustomUser user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userStore.put(user.getUserName(),user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomUser> userFound =  userStore.entrySet()
                .stream()
                .filter( entry -> entry.getValue().getUserName().equals(username))
                .findFirst()
                .map(Map.Entry::getValue);

        if(userFound.isEmpty())
          throw new UsernameNotFoundException("User does not exists!");

        return new User(userFound.get().getUserName(),userFound.get().getPassword(), Collections.emptyList());
    }
}
