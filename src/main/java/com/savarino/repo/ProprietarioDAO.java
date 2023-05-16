package com.savarino.repo;


import com.savarino.entities.Cane;
import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Proprietario;
import java.util.List;
import java.util.Optional;

public interface ProprietarioDAO extends JpaRepository<Proprietario, Integer>  {
	
  
    Optional<Proprietario> findByUsernameAndPassword(String u,String p);
}
