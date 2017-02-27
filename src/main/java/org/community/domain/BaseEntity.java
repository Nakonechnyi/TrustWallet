package org.community.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import java.io.Serializable;

/**
 * Created by a.nakonechnyi on 26.02.2017.
 */
public class BaseEntity implements Serializable {


    @Id
    private ObjectId id;

    @Getter
    @JsonProperty("id")
    private String computedId;

}
