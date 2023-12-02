package br.com.seteideias.springkeycloack.controller;

import br.com.seteideias.springkeycloack.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService service;

    @GetMapping("/getlist")
    @PreAuthorize("hasHole('USER')")
    public List<String> productList(){
        return Arrays.asList("produto1","produto2");
    }

    @PostMapping("/insert")
    @PreAuthorize("hasHole('ADMIN')")
    public void insert() {
        service.insertNew();
    }

}
