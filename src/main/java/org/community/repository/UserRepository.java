package org.community.repository;

import org.community.domain.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;

/**
 * Created by a.nakonechnyi on 26.02.2017.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository {

    @Query(value = "{ 'name': {$in: ['?0']} , 'middleName': {$in: ['?1']}, 'surName': {$in: ['?2']}, 'birth': {$in: ['?3']} } ",
            fields = "{ login: 1 }")
    User findOneByNameAndMiddleNameAndSurNameAndBirth(String name, String middleName, String surName, Date birth);

    User save(User registration);
}
