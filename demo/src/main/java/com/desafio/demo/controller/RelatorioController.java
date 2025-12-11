package com.desafio.demo.controller;


import com.desafio.demo.service.DesafioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;


@Controller
public class RelatorioController {

    private final DesafioService service;

    
    // Injeção de dependência do Service
    public RelatorioController(DesafioService service) {

        this.service = service;

    }


    @GetMapping("/")
    public String exibirRelatorio(Model model) {

        // Chama o processamento
        Map<String, Object> dados = service.processarRelatorio();
        
        // Passa os dados para o HTML (Thymeleaf)
        model.addAttribute("alunos", dados.get("alunos"));
        model.addAttribute("cursos", dados.get("cursos"));
        
        return "relatorio"; // Nome do arquivo HTML sem a extensão

    }

}