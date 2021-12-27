package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.DoctorDTO;

public interface IDoctorService {
	
	DoctorDTO save(DoctorDTO doctor);

	List<DoctorDTO> getAll();

	List<DoctorDTO> delete(Long id);

	DoctorDTO update(Long id, DoctorDTO doctor);

}
