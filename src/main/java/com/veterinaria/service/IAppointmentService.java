package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.AppointmentDTO;


public interface IAppointmentService {
	
	AppointmentDTO save(AppointmentDTO appointment);

	List<AppointmentDTO> getAll();

	List<AppointmentDTO> delete(Long id);

	AppointmentDTO update(Long id, AppointmentDTO appointment);


}
