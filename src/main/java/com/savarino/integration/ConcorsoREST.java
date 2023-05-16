package com.savarino.integration;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savarino.entities.Cane;
import com.savarino.entities.Proprietario;
import com.savarino.services.CaneService;
import com.savarino.services.ProprietarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

@RestController
@RequestMapping("api")
public class ConcorsoREST {

    @Autowired
    private ProprietarioService proprietarioService;

    @Autowired
    private CaneService caneService;

    @GetMapping("proprietari")
    public List<Proprietario> getProprietari() {
        return proprietarioService.listaProprietari();
    }

    @GetMapping("caniClassificaUtenteCorrente")
    public List<Cane> getCaniUtenteCorrente(HttpSession s) {

        System.out.println("-GET CANI UTENTE CORRENTE-");
        
        Proprietario utenteCorrente = (Proprietario) s.getAttribute("loginUser");

        if (utenteCorrente != null) {
            List<Cane> cani = caneService.findCaniByProprietario(utenteCorrente);
            return cani;
        } else {
            System.err.println("-UTENTE CORRENTE NON TROVATO-");
            return new java.util.ArrayList<>();
        }

    }

    @GetMapping("caniClassifica")
    public List<Cane> getCaniClassifica() {
        List<Cane> cani = caneService.findAllByOrderByVotoDesc();
        return cani;
    }

    @PostMapping(value = "nuoviCani", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> addCane(@ModelAttribute Cane cane) {
        caneService.addCane(cane);
        return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(cane.getId()).toString());
    }

    @PostMapping(value = "nuoviProprietari", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> addProprietario(@ModelAttribute Proprietario proprietario) {
        proprietarioService.addProprietario(proprietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(proprietario.getId()).toString());
    }

}
