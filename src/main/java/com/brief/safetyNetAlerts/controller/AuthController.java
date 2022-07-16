package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.Service.ServiceImpl.PersonDetailsImpl;
import com.brief.safetyNetAlerts.Service.jwt.JwtUtils;
import com.brief.safetyNetAlerts.Service.payload.request.LoginRequest;
import com.brief.safetyNetAlerts.Service.payload.request.SignupRequest;
import com.brief.safetyNetAlerts.Service.payload.response.JwtResponse;
import com.brief.safetyNetAlerts.Service.payload.response.MessageResponse;
import com.brief.safetyNetAlerts.model.Person;
import com.brief.safetyNetAlerts.model.Role;
import com.brief.safetyNetAlerts.model.emunModel.ERole;
import com.brief.safetyNetAlerts.repository.PersonRepository;
import com.brief.safetyNetAlerts.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        PersonDetailsImpl userDetails = (PersonDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getLastName(),
                roles));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Person user = new Person(signUpRequest.getUsername(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = new HashSet<String>(Collections.singletonList(signUpRequest.getRole()));
//        Set<Role> roles = new HashSet<>();

//        if (strRoles.isEmpty()) {
//            Role investRole = roleRepository.findByName(ERole.ROLE_INVESTISSEUR)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//
//           roles.add(investRole);
//        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role  admin is not found."));
                        user.setRole(adminRole);
//                        roles.add(adminRole);
                        break;
                    case "entrepreneur":
                        Role entrRole = roleRepository.findByName(ERole.ROLE_ENTREPRENEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role mod is not found."));
//                        roles.add(entrRole);
                        user.setRole(entrRole);
                        break;
                    case "investisseur":
                        Role investRole = roleRepository.findByName(ERole.ROLE_INVESTISSEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role user is not found."));
                        user.setRole(investRole);
//                        roles.add(investRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_INVESTISSEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role user is not found."));
                        user.setRole(userRole);
//                        roles.add(userRole);

                        break;
                }
            });
//        }
//            user.setRole(roles);
            userRepository.save(user);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
}