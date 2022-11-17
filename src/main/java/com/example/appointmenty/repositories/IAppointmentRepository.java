package com.example.appointmenty.repositories;

import com.example.appointmenty.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, UUID> {
}
