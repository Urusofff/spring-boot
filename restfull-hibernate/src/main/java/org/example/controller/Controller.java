package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dao.entity.User;
import org.example.dao.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class Controller {

    UserService userService;

    @GetMapping("/{userid}")
    public ResponseEntity<Object> getUser(@PathVariable String userId) {
        return userService.findById(Integer.parseInt(userId));
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String userId) {
        return userService.updateUser(Integer.parseInt(userId));
    }
}
