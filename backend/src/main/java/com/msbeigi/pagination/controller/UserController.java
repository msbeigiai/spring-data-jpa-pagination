package com.msbeigi.pagination.controller;

import com.msbeigi.pagination.domain.HttpResponse;
import com.msbeigi.pagination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<HttpResponse> getUsers(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size) throws InterruptedException {
        Thread.sleep(3000);
//        throw new RuntimeException("Forced exception for testing");
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timestamp(LocalDateTime.now().toString())
                        .data(
                                Map.of(
                                        "page",
                                        userService.getUsers(name.orElse(""),
                                                page.orElse(0),
                                                size.orElse(10))
                                )
                        )
                        .message("Users retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
