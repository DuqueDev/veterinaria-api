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

import com.veterinaria.domain.PharmacyDTO;
import com.veterinaria.service.IPharmacyService;

@CrossOrigin
@RestController
@RequestMapping("/pharmacy")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class PharmacyController {

	@Autowired
	private IPharmacyService service;

	@PostMapping
	public PharmacyDTO save(@RequestBody PharmacyDTO pharmacy) {
		return service.save(pharmacy);
	}

	@GetMapping
	public List<PharmacyDTO> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{idPharmacy}")
	public List<PharmacyDTO> delete(@PathVariable Long idPharmacy) {
		return service.delete(idPharmacy);
	}

	@PutMapping("/{idPharmacy}")
	public PharmacyDTO update(@PathVariable Long idPharmacy, @RequestBody PharmacyDTO pharmacy) {
		return service.update(idPharmacy, pharmacy);
	}

}
