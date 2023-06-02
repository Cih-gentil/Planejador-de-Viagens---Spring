package br.com.senacsp.planejadorviagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.senacsp.planejadorviagem.model.Hospedagem;
import br.com.senacsp.planejadorviagem.repository.HospedagemRepository;



@Controller
public class HospedagemController {

    @Autowired
    HospedagemRepository repository;

    @GetMapping("/hospedagem")
    public String hospedagem() {
    return "hospedagem";
    }  
    

    @GetMapping("hospedagem/cadastrar")
    public String formulario(){
        return "formulario_hospedagem";
    }

    @GetMapping("hospedagem/listar")
    public String listar(Model model){
        var lista = repository.findAll();
        model.addAttribute("lista", lista);
        return "listaHospedagem";
    }

    @PostMapping("/hospedagem") 
    public String cadastrar(Hospedagem hospedagem) {
        repository.save(hospedagem); 
        return "redirect:/hospedagem";

    }
    @PostMapping("/hospedagem/listar")
    public String apagar(@RequestParam("id") Long id){
        repository.deleteById(id);
        return "redirect:/hospedagem/listar";
    }


}







