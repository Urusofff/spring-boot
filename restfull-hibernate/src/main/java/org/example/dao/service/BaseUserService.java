package org.example.dao.service;

import lombok.AllArgsConstructor;
import org.example.dao.entity.User;
import org.example.exception.UserExistingEmailException;
import org.example.exception.UserNotFoundException;
import org.example.repository.UserRepository;
import org.example.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.example.dao.entity.User.UserStatus.OFFLINE;
import static org.example.dao.entity.User.UserStatus.ONLINE;

@Service
@AllArgsConstructor
public class BaseUserService implements UserService {

    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> save(User user) {

        User userFromDb = userRepository.findByEmail(user.getEmail()).get();
        if (user.getEmail().equalsIgnoreCase(userFromDb.getEmail())) {
            throw new UserExistingEmailException("User with this email exist.");
        }
        userRepository.save(user);
        return ResponseHandler.responseBuilder("user saved", HttpStatus.OK, user.getId());
    }

    @Override
    public ResponseEntity<Object> findById(long id) {

        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User not exist.");
        }
        return ResponseHandler.responseBuilder("user found",
                HttpStatus.OK,
                userRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {

        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User not exist.");
        }

        User user = userRepository.findById(id).get();

        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", String.valueOf(user.getId()));
        updateResponse.put("previous status", user.getUserStatus().name());

        String CURRENT_STATUS = "current status";

        if (user.getUserStatus().equals(OFFLINE)) {
            user.setUserStatus(ONLINE);
            updateResponse.put(CURRENT_STATUS, user.getUserStatus().name());
        } else {
            user.setUserStatus(OFFLINE);
            updateResponse.put(CURRENT_STATUS, user.getUserStatus().name());
        }
        userRepository.save(user);

        return ResponseHandler.responseBuilder("user updated",
                HttpStatus.OK,
                updateResponse);
    }
}
