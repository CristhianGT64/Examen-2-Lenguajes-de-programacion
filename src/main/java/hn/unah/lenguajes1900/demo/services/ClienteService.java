package hn.unah.lenguajes1900.demo.services;

import java.util.List;

import hn.unah.lenguajes1900.demo.entities.Cliente;

public interface ClienteService {
    
    public Cliente CreaCliente(Cliente cliente);

    public List<Cliente> ObtenerCliente();

}
