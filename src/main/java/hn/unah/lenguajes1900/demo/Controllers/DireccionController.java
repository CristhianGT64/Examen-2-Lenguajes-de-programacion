package hn.unah.lenguajes1900.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.demo.entities.Direccion;
import hn.unah.lenguajes1900.demo.services.impl.DireccionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class DireccionController {

    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/Direccion/Crear/{dni}")
    public Direccion CrearDireccion(@RequestBody Direccion direccion, @PathVariable String dni) {
        
        return this.direccionServiceImpl.CrearDireccion(direccion, dni);
    }
    
}
