package org.community.exception;

/**
 * Created by a.nakonechnyi on 26.02.2017.
 */
public class PersonAlreadyRegisteredException extends Exception {

    public PersonAlreadyRegisteredException(String message) {
        super(message);
    }
}
