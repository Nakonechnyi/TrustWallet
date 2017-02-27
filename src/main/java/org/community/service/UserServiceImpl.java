package org.community.service;

import org.community.domain.User;
import org.community.exception.PersonAlreadyRegisteredException;
import org.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by a.nakonechnyi on 26.02.2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public User register(User registration) throws PersonAlreadyRegisteredException {
        if (userRepository.findOneByNameAndMiddleNameAndSurNameAndBirth(
                registration.getName(),
                registration.getMiddleName(),
                registration.getSurName(),
                registration.getBirth()) != null) {
            throw new PersonAlreadyRegisteredException("Person Already Registered");
        }
        registration.setPassword(bCryptPasswordEncoder().encode(registration.getPassword()));
        return userRepository.save(registration);
    }
}
