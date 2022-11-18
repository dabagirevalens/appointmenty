package com.example.appointmenty.servicesImpl;

import com.example.appointmenty.models.Appointment;
import com.example.appointmenty.repositories.IAppointmentRepository;
import com.example.appointmenty.services.IAppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
