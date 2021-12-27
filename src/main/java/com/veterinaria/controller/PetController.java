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

import com.veterinaria.domain.PetDTO;
import com.veterinaria.service.IPetService;

@CrossOrigin
@RestController
@RequestMapping("/pet")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class PetController {
	@Autowired
	private IPetService service;

	@PostMapping
	public PetDTO save(@RequestBody PetDTO pet) {
		return service.save(pet);
	}

	@GetMapping
	public List<PetDTO> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{idPet}")
	public List<PetDTO> delete(@PathVariable Long idPet) {
		return service.delete(idPet);
	}

	@PutMapping("/{idPet}")
	public PetDTO update(@PathVariable Long idPet, @RequestBody PetDTO pet) {
		return service.update(idPet, pet);
	}
}