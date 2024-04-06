package hn.unah.lenguajes1900.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.demo.dtos.CrearMovimiento;
import hn.unah.lenguajes1900.demo.entities.Movimiento;
import hn.unah.lenguajes1900.demo.services.impl.MovimientoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class MovimientoController {

    @Autowired
    private MovimientoServiceImpl movimientoServiceImpl;

    @PostMapping("/Movimiento/CrearMovimiento")
    public Movimiento CrearMovimiento(@RequestBody CrearMovimiento crearMovimiento) {
        
        return this.movimientoServiceImpl.CreaMovimiento(crearMovimiento);
        
    }
    
}
