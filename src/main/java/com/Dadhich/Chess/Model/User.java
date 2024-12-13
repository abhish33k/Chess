package com.Dadhich.Chess.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "chess")
public class User {
@Id
private String id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

}
