package com.underscore.banka.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String middleName;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
