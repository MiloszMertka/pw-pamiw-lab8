package com.example.api.controller;

import com.example.api.dto.ChangePasswordDto;
import com.example.api.dto.JwtDto;
import com.example.api.dto.LoginUserDto;
import com.example.api.dto.RegisterUserDto;
import com.example.api.service.AuthUseCases;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
class AuthController {

    private final AuthUseCases authUseCases;

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody @Valid LoginUserDto loginUserDto) {
        final var jwt = authUseCases.login(loginUserDto);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterUserDto registerUserDto) {
        authUseCases.register(registerUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/change-password/{id}")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody @Valid ChangePasswordDto changePasswordDto) {
        authUseCases.changePassword(id, changePasswordDto);
        return ResponseEntity.noContent().build();
    }

}
