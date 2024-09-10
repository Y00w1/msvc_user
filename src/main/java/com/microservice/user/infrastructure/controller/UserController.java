package com.microservice.user.infrastructure.controller;

import com.microservice.user.application.dto.user.CreateUserWarehouseAssistantDto;
import com.microservice.user.application.dto.user.UserDto;
import com.microservice.user.application.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create/warehouse-assistant")
    public ResponseEntity<UserDto> createWarehouseAssistant(@Valid @RequestBody CreateUserWarehouseAssistantDto createUserWarehouseAssistantDto) {
        return ResponseEntity.ok(userService.createWarehouseAssistant(createUserWarehouseAssistantDto));
    }
}
