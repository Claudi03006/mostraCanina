package com.savarino.services;

import java.util.List;

import com.savarino.entities.Cane;
import com.savarino.entities.Proprietario;

public interface CaneService {
	List<Cane>findAllByOrderByVotoDesc();
	void addCane(Cane cane);
	List<Cane>findCaniByProprietario(Proprietario proprietario);

}
