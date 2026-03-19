package com.kasiakab.dockernetworkingdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class UserProfile {

    @Id
    private String id;

    private Integer userid = 1;

    private String name;
    private String email;
    private String interests;
}
