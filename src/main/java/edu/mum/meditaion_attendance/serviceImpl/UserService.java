package edu.mum.meditaion_attendance.serviceImpl;

import java.util.Arrays;
import java.util.HashSet;

import edu.mum.meditaion_attendance.domain.Role;
import edu.mum.meditaion_attendance.domain.User;
import edu.mum.meditaion_attendance.repository.RoleRepository;
import edu.mum.meditaion_attendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User saveUser(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();

    }
}