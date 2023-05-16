package com.savarino.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaneController {

    @GetMapping("classifica")
    public String caniView() {
        return "classifica";
    }
    
    @GetMapping("imieicani")
    public String imieiCaniView() {
        return "imieicani";
    }
}
