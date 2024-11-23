package org.yascode.products_management.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yascode.products_management.api.request.AuthenticationRequest;

import static org.yascode.products_management.util.ApiPaths.Auth.AUTH;

@RequestMapping(AUTH)
public interface AuthenticationApi {
    @PostMapping("/authenticate")
    ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest);
}
