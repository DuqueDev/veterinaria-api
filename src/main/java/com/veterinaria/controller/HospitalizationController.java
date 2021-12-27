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

import com.veterinaria.domain.HospitalizationDTO;
import com.veterinaria.service.IHospitalizationService;

@CrossOrigin
@RestController
@RequestMapping("/hospitalization")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")

public class HospitalizationController {


		@Autowired
		private IHospitalizationService service;

		@PostMapping
		public HospitalizationDTO save(@RequestBody HospitalizationDTO hospitalization) {
			return service.save(hospitalization);
		}

		@GetMapping
		public List<HospitalizationDTO> getAll() {
			return service.getAll();
		}

		@DeleteMapping("/{idHospitalization}")
		public List<HospitalizationDTO> delete(@PathVariable Long idHospitalization) {
			return service.delete(idHospitalization);
		}

		@PutMapping("/{idHospitalization}")
		public HospitalizationDTO update(@PathVariable Long idHospitalization, @RequestBody HospitalizationDTO hospitalization) {
			return service.update(idHospitalization, hospitalization);
		}
		
	}


