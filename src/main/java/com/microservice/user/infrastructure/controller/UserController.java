package com.microservice.user.infrastructure.controller;

import com.microservice.user.application.dto.user.CreateUserWarehouseAssistantDto;
import com.microservice.user.application.dto.user.UserDto;
import com.microservice.user.application.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create a new warehouse assistant user",
            description = "Creates a new user with the role 'aux_bodega' and validates required fields.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)
    })
    @PostMapping("/create/warehouse-assistant")
    public ResponseEntity<UserDto> createWarehouseAssistant(@Valid @RequestBody CreateUserWarehouseAssistantDto createUserWarehouseAssistantDto) {
        return ResponseEntity.ok(userService.createWarehouseAssistant(createUserWarehouseAssistantDto));
    }
}
