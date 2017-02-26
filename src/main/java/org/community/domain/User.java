package org.community.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.community.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by a.nakonechnyi on 25.02.2017.
 */
@Data
@ToString(exclude = "password")
@Document(collection = User.COLLECTION_NAME)
public class User extends BaseEntity {

    public static final String COLLECTION_NAME = "users";
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[a-z]*$")
    private String login;

    @NotEmpty
    @Size (min = 5)
    @JsonIgnore
    private String password;

    @NotEmpty
    @Size(min = 2)
    private String name;

    @NotEmpty
    @Size(min = 2)
    private String surName;

    @NotEmpty
    @Size(min = 2)
    private String middleName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Phone
    private String phone;

    private String locale;

    @NotEmpty
    private Date birth;

    private Role[] roles;

    private List<Contact> contacts;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocale() {
        return locale;
    }

    public Date getBirth() {
        return birth;
    }

    public Role[] getRoles() {
        return roles;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }


}
