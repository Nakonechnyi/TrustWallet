package org.community.service;

import org.community.domain.User;
import org.community.exception.PersonAlreadyRegisteredException;
import org.springframework.stereotype.Service;

/**
 * Created by a.nakonechnyi on 25.02.2017.
 */
@Service
public interface UserService {

    User register(User registration) throws PersonAlreadyRegisteredException;
}
