package hn.unah.lenguajes1900.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.demo.Repositories.ClientreRepositorie;
import hn.unah.lenguajes1900.demo.Repositories.DireccionRepositorie;
import hn.unah.lenguajes1900.demo.entities.Cliente;
import hn.unah.lenguajes1900.demo.entities.Direccion;
import hn.unah.lenguajes1900.demo.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private DireccionRepositorie direccionRepositorie;

    @Autowired
    private ClientreRepositorie clientreRepositorie;

    @Override
    public Direccion CrearDireccion(Direccion direccion, String dni) {
        if (this.clientreRepositorie.findById(dni).isPresent()) {
            Cliente cliente = this.clientreRepositorie.findById(dni).get();
            direccion.setCliente(cliente);
            return this.direccionRepositorie.save(direccion);
        }
        return null;
    }
    
}
