package com.example.profileservice.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Node("User")
@FieldDefaults(level = AccessLevel.PRIVATE )
public class User {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    String id;

    @Property("username")
    String username;

    @Property("email")
    String email;

    @Property("password")
    String password;

    @Property("avatar")
    String avatar;



    @Property("phonenumber")
    String phonenumber;

    Boolean isactive;

    Date createdAt;
    Date updatedAt;

}
