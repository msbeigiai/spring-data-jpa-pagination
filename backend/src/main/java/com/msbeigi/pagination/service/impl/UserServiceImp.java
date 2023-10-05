package com.msbeigi.pagination.service.impl;

import com.msbeigi.pagination.domain.User;
import com.msbeigi.pagination.repository.UserRepository;
import com.msbeigi.pagination.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching users for page {} of size {}", page, size);
        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }
}
