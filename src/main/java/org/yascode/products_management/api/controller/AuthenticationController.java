package org.yascode.products_management.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.products_management.api.AuthenticationApi;
import org.yascode.products_management.api.request.AuthenticationRequest;
import org.yascode.products_management.api.response.AuthenticationResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController implements AuthenticationApi {

    @Override
    public ResponseEntity<?> authenticate(AuthenticationRequest authenticationRequest) {
        System.out.println(authenticationRequest);
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        // with admin role
        if (username.equals("yascode") && password.equals("yascode123")) {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwic3ViIjoiMTIzNDU2Nzg5MCIsIm5hbWUiOiJZYXNzaW4gTUVMTE9VS0kiLCJ1c2VybmFtZSI6ImpZYXNDb2RlIiwiaWF0IjoxNzMyMzg4ODg4LCJyb2xlcyI6WyJBRE1JTiJdfQ.hPnir3ZpypV5lcf33kuPD0HEatC-3irIMrvp3S3yY2k";
            return ResponseEntity.ok(AuthenticationResponse.builder().token(token).build());
        }

        // with user role
        if(username.equals("yascode") && password.equals("yascode")) {
            String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwic3ViIjoiMTIzNDU2Nzg5MCIsIm5hbWUiOiJZYXNzaW4gTUVMTE9VS0kiLCJ1c2VybmFtZSI6ImpZYXNDb2RlVXNlciIsImlhdCI6MTczMjM4ODg4OCwicm9sZXMiOlsiVVNFUiJdfQ.xAMs0GDnBMBma7TcMGnJxs1hbxxKVvU3z3UQFE8a-yI";
            return ResponseEntity.ok(AuthenticationResponse.builder().token(token).build());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
