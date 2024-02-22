package org.example.dao.service;

import org.example.dao.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    ResponseEntity<Object> save(User user);

    ResponseEntity<Object> findById(long id);

    ResponseEntity<Object> updateUser(long id);

}
