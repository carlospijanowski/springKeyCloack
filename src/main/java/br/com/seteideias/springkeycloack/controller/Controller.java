package br.com.seteideias.springkeycloack.controller;

import br.com.seteideias.springkeycloack.service.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {

    @Autowired
    private CadastroProdutoService service;

    @GetMapping("/")
    public List<String> productList(){
        return Arrays.asList("produto1","produto2");
    }

    @PostMapping("/")
    protected void create() {
        service.doCadastro();
    }
}
