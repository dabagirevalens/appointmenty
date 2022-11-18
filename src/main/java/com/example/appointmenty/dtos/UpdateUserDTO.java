package com.example.appointmenty.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDTO {
    @NotNull
    private String name;

    @NotNull
    private String email;

    public UpdateUserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
