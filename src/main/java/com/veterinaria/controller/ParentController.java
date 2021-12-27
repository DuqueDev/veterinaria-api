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

import com.veterinaria.domain.ParentDTO;
import com.veterinaria.service.IParentService;

@CrossOrigin
@RestController
@RequestMapping("/parents")
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class ParentController {

	@Autowired
	private IParentService service;

	@PostMapping
	public ParentDTO save(@RequestBody ParentDTO parent) {
		return service.save(parent);
	}

	@GetMapping
	public List<ParentDTO> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{idParent}")
	public List<ParentDTO> delete(@PathVariable Long idParent) {
		return service.delete(idParent);
	}

	@PutMapping("/{idParent}")
	public ParentDTO update(@PathVariable Long idParent, @RequestBody ParentDTO parent) {
		return service.update(idParent, parent);
	}
	
}
