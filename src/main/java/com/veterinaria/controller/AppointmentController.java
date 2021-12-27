

package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.domain.AppointmentDTO;
import com.veterinaria.service.IAppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/appointment")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")

public class AppointmentController {

	@Autowired
	private IAppointmentService service;

	@PostMapping
	public AppointmentDTO save(@RequestBody AppointmentDTO appointment) {
		return service.save(appointment);
	}

	@GetMapping
	public List<AppointmentDTO> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{idAppointment}")
	public List<AppointmentDTO> delete(@PathVariable Long idAppointment) {
		return service.delete(idAppointment);
	}

	@PutMapping("/{idAppointment}")
	public AppointmentDTO update(@PathVariable Long idAppointment, @RequestBody AppointmentDTO appointment) {
		return service.update(idAppointment, appointment);
	}
}
