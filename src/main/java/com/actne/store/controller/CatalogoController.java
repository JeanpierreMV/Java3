package com.actne.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

import com.actne.store.model.Producto;
import com.actne.store.repository.ProductoRepository;



@Controller
public class CatalogoController {

    private static final String INDEX="catalogo/index";
    private final ProductoRepository productsData;

    public CatalogoController(ProductoRepository ProductsData){
        
        this.productsData = ProductsData;        
    }

    @GetMapping("/catalogo/index")
    public String index(@RequestParam(defaultValue="") String searchName, Model model){

        List<Producto> listProducto= null;
        if(searchName.isEmpty()){
            listProducto = this.productsData.getAllActiveProducto();
        }else{
            listProducto = this.productsData.getAllActiveProductoBySearch(searchName);
        }       

        model.addAttribute( "products", listProducto);

        return INDEX;
    }
    
}
