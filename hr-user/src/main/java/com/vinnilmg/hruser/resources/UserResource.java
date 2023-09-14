package com.vinnilmg.hruser.resources;

import com.vinnilmg.hruser.entities.User;
import com.vinnilmg.hruser.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("Buscando usuário com ID {}", id);
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        log.info("Buscando usuário com email: {}", email);
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}
