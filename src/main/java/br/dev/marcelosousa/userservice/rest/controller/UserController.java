package br.dev.marcelosousa.userservice.rest.controller;

import br.dev.marcelosousa.userservice.dto.UserDTO;
import br.dev.marcelosousa.userservice.exceptions.EmailUniquenessException;
import br.dev.marcelosousa.userservice.model.User;
import br.dev.marcelosousa.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDTO userDTO){
        System.out.print(userRepository.existsByEmail(userDTO.getEmail()));
        if(userRepository.existsByEmail(userDTO.getEmail())) {
            log.info("Email already in use {}", userDTO.getEmail());
            throw new EmailUniquenessException("Email already in use");
        } else {
            var user = new User();
            user.setActive(false);
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setPassword(userDTO.getPassword());
            userRepository.save(user);

            log.info("User created {}", user);

            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
    }
}
