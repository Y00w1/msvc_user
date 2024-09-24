package com.microservice.user.infrastructure.controller;

import com.microservice.user.application.dto.authentication.AuthRespDto;
import com.microservice.user.application.dto.authentication.LoginReqDto;
import com.microservice.user.application.dto.authentication.SignupReqDto;
import com.microservice.user.application.services.AuthenticationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthRespDto> login(@Valid @RequestBody LoginReqDto loginReqDto) {
        return ResponseEntity.ok(authenticationService.login(loginReqDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthRespDto> signup(@Valid @RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(authenticationService.signup(signupReqDto));
    }

}
