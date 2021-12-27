package com.veterinaria.service;

import java.util.List;


import com.veterinaria.domain.PharmacyDTO;


public interface IPharmacyService {
	
	PharmacyDTO save(PharmacyDTO pharmacy);

	List<PharmacyDTO> getAll();

	List<PharmacyDTO> delete(Long id);

	PharmacyDTO update(Long id, PharmacyDTO pharmacy);

}



