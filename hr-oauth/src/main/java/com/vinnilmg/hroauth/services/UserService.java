package com.vinnilmg.hroauth.services;

import com.vinnilmg.hroauth.entities.User;
import com.vinnilmg.hroauth.feignclients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findUserByEmail(username);

        if (isNull(user)) {
            log.error("Username not found: {}", username);
            throw new UsernameNotFoundException("Username not found.");
        }

        log.info("Usuário localizado: {}", user.toString());
        return user;
    }

    public User findByEmail(String email) {
        User user = findUserByEmail(email);

        if (isNull(user)) {
            log.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found.");
        }

        log.info("Usuário localizado: {}", user.toString());
        return user;
    }

    private User findUserByEmail(String email) {
        return userFeignClient.findByEmail(email).getBody();
    }

}
