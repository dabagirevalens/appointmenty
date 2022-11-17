package com.example.appointmenty.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO  {
    @NotNull
    private String name;

    @NotNull
    private String email;
}
