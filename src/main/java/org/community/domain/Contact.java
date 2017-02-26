package org.community.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.community.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by a.nakonechnyi on 25.02.2017.
 */
@Data
@Document(collection = Contact.COLLECTION_NAME)
public class Contact extends BaseEntity {
    public static final String COLLECTION_NAME = "contacts";

    private Long parentId;

    @JsonIgnore
    private Long contactId;

    private String contactInfo;

    @Phone
    private String phone;

    @Email
    private String email;
}
