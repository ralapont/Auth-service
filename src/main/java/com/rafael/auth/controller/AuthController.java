package com.rafael.auth.controller;


import com.rafael.auth.dtos.AuthRequest;
import com.rafael.auth.dtos.AuthResponse;
import com.rafael.auth.dtos.RegisterRequest;
import com.rafael.auth.services.ApplicationUserDetailsService;
import com.rafael.auth.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ApplicationUserDetailsService userService;
    private final JwtService jwtService;

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    // Registro
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    // Logout (opcional)
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Si usas JWT, el logout se maneja en el cliente (elimina el token)
        return ResponseEntity.ok("Logout exitoso");
    }
}
