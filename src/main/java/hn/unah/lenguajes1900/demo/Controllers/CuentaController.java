package hn.unah.lenguajes1900.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.demo.entities.Cuenta;
import hn.unah.lenguajes1900.demo.services.impl.CuentaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class CuentaController {

    @Autowired
    private CuentaServiceImpl cuentaServiceImpl;

    @PostMapping("/Cuenta/Crear")
    public Cuenta CrearCuenta(@RequestBody Cuenta cuenta) {
        
        return this.cuentaServiceImpl.CrearCuenta(cuenta);
    }

    @PutMapping("/Cuenta/Asociar/{dni}")
    public Cuenta CrearCuenta(@PathVariable String dni, @RequestParam String numCuenta) {
        return this.cuentaServiceImpl.AsosciarCuentaCliente(dni, numCuenta);
    }
    
}
