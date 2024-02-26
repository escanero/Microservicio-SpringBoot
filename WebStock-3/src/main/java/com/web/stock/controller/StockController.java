package com.web.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.web.stock.modelo.Producto;
import com.web.stock.modelo.Producto.TipoProducto;
import com.web.stock.service.ProductoService;

@Controller
public class StockController {
    
    @Autowired
    private ProductoService productoService;
    
    
    @GetMapping("/")
    public String index() {
        return "login-form"; 
    }
    
    @GetMapping("/login")
    public String login() {
        return "login-form"; 
    }
    
    @GetMapping("/portal")
    public String portal() {
        return "portal"; 
    }
 
    @GetMapping("/portal/registro")                /*Model   representa la parte de datos, la Vista es la representación visual de estos datos, y el Controlador maneja la lógica de la aplicación.*/
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("tipos", TipoProducto.values());
        model.addAttribute("accion", "crear");
        return "producto-form";
    }
    
    @GetMapping("/portal/listado")
    public String listaProductos() {
        return "productos-list"; 
    }
 
    
    @GetMapping("/actualizar/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.getProductoById(id);
        model.addAttribute("producto", producto);
        model.addAttribute("tipos", TipoProducto.values());
        model.addAttribute("accion", "editar");
        return "producto-form";
    }
}

