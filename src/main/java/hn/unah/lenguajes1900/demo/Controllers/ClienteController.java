package hn.unah.lenguajes1900.demo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes1900.demo.entities.Cliente;
import hn.unah.lenguajes1900.demo.services.impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/Cliente/Crear")
    public Cliente CrearCliente(@RequestBody Cliente Cliente) {
        return this.clienteServiceImpl.CreaCliente(Cliente);
    }

    @GetMapping("/Cliente/Todos")
    public List<Cliente> TraerClientes() {
        return this.clienteServiceImpl.ObtenerCliente();
    }
    
    
}
