package com.lcorp.shoppyservice.service;

import com.lcorp.shoppyservice.model.Role;
import com.lcorp.shoppyservice.model.RoleEnum;
import com.lcorp.shoppyservice.model.User;
import com.lcorp.shoppyservice.repository.RoleRepository;
import com.lcorp.shoppyservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User createUser(User user)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName(RoleEnum.ROLE_USER);
        user.setRoles(roles);
        User savedUser = userRepository.save(user);
        return savedUser;

    }

    public boolean checkExistingUser(User user)
    {
        if (userRepository.existsByEmail(user.getEmail())) {
            return true;
        }
        return false;
    }
}
