package com.actne.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.actne.store.model.Calculadora;



@Controller

public class CalculadoraController {

    private static final String INDEX = "Calculadora/calculator";
    
    @GetMapping("/Calculadora/calculator")
    public String index(Model model) {
     
        model.addAttribute("calculadora", new Calculadora());
        return INDEX;
    }

    @PostMapping("/calcular")
    public String calcular(Model model,@Valid Calculadora objCalculadora, BindingResult result){
        
        Integer resultado = 0;

        if("+".equals(objCalculadora.getOperando())){

            resultado =objCalculadora.getOperador1()+objCalculadora.getOperador2();

        }else{
            resultado =objCalculadora.getOperador1()-objCalculadora.getOperador2();
        }
        String respuesta = "El resultado es: "+resultado;

        model.addAttribute("mensaje", respuesta); 
                              
    return INDEX;
    }
}
