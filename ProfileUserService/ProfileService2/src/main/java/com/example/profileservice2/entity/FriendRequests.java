package com.example.profileservice2.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Node("FriendRequests")
@FieldDefaults(level = AccessLevel.PRIVATE )
public class FriendRequests {
    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    String request_id;
    String sender_user;
    String receiver_user;
    String status;
    String send_user; //fk
    String user_receive; //fk
    Date createdAt;
    Date updatedAt;

}