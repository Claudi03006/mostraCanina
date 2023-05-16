package com.savarino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savarino.entities.Cane;
import com.savarino.entities.Proprietario;
import com.savarino.repo.CaneDAO;
import com.savarino.repo.ProprietarioDAO;

@Service
public class CaneServiceImpl implements CaneService {

    @Autowired
    private CaneDAO caneDAO;

    @Autowired
    private ProprietarioDAO proprietarioDAO;

    @Override
    public List<Cane> findAllByOrderByVotoDesc() {
        // TODO Auto-generated method stub
        return caneDAO.findAllByOrderByVotoDesc();
    }

    @Override
    public void addCane(Cane cane) {
        // TODO Auto-generated method stub
        caneDAO.save(cane);

    }

    @Override
    public List<Cane> findCaniByProprietario(Proprietario proprietario) {
        return this.caneDAO.findByProprietarioOrderByVotoDesc(proprietario);
    }

}
