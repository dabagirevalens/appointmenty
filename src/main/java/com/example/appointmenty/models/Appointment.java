package com.example.appointmenty.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
