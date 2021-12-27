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

import com.veterinaria.domain.DoctorDTO;
import com.veterinaria.service.IDoctorService;

	@CrossOrigin
	@RestController
	@RequestMapping("/doctors")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	
public class DoctorController {

		@Autowired
		private IDoctorService service;

		@PostMapping
		public DoctorDTO save(@RequestBody DoctorDTO doctor) {
			return service.save(doctor);
		}

		@GetMapping
		public List<DoctorDTO> getAll() {
			return service.getAll();
		}

		@DeleteMapping("/{idDoctor}")
		public List<DoctorDTO> delete(@PathVariable Long idDoctor) {
			return service.delete(idDoctor);
		}

		@PutMapping("/{idDoctor}")
		public DoctorDTO update(@PathVariable Long idDoctor, @RequestBody DoctorDTO doctor) {
			return service.update(idDoctor, doctor);
		}
		
	}



