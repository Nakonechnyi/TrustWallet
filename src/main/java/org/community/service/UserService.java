package org.community.service;

import org.community.domain.User;
import org.community.exception.PersonAlreadyRegisteredException;

/**
 * Created by a.nakonechnyi on 25.02.2017.
 */
public interface UserService {

    User register(User registration) throws PersonAlreadyRegisteredException;
}
