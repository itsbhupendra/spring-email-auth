package com.example.springemailauthentication.registration;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor

@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

}
