package com.actne.store.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actne.store.model.Producto;
import com.actne.store.repository.ProductoRepository;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

@RestController
@RequestMapping(value = "api/productos", produces = "application/json")
public class ProductoRestController {
    private final ProductoRepository productsData;

    public ProductoRestController(ProductoRepository productsData){
        this.productsData = productsData;

    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> productos(){
        return new ResponseEntity<List<Producto>>( productsData.findAll(), HttpStatus.OK);
    }
    
}
