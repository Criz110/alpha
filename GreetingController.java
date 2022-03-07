/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.make.controller;

import com.make.model.Persona;
import com.make.repo.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    
    @Autowired
    private IPersonaRepo repo;
    
	@GetMapping("/greeting")
	public String Saludos(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            //logica de negocios
             
            Persona p= new Persona();
            p.setIdPersona(4);
            p.setNombre("delgado");
            repo.save(p);
                   
            
		model.addAttribute("name", name);
		return "greeting"; 
	}
        
        @GetMapping("/listar")
	public String listasDatos(@RequestParam(name="name", required=false, defaultValue="World" ) String name,  Model model) {
            //logica de negocios
             
		model.addAttribute("personas", repo.findAll());
                model.addAttribute("name", name);
		return "greeting"; //retorna el archivo donde va a mandar los datos
	}

}