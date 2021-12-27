package com.veterinaria.service;

import java.util.List;

import com.veterinaria.domain.HospitalizationDTO;

public interface IHospitalizationService {

	HospitalizationDTO save(HospitalizationDTO hospitalization);

	List<HospitalizationDTO> getAll();

	List<HospitalizationDTO> delete(Long id);

	HospitalizationDTO update(Long id, HospitalizationDTO hospitalization);

}
