package com.example.chatservice.Form;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserMemberUpdate {
    String nameUser;


}
