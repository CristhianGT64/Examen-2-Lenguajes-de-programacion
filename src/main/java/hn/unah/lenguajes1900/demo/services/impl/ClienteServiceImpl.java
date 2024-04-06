package hn.unah.lenguajes1900.demo.services.impl;

import java.util.List;

import javax.print.DocFlavor.READER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.demo.Repositories.ClientreRepositorie;
import hn.unah.lenguajes1900.demo.Repositories.CuentaRepositorie;
import hn.unah.lenguajes1900.demo.entities.Cliente;
import hn.unah.lenguajes1900.demo.entities.Cuenta;
import hn.unah.lenguajes1900.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClientreRepositorie clientreRepositorie;

    @Autowired
    private CuentaRepositorie cuentaRepositorie;

    @Override
    public Cliente CreaCliente(Cliente cliente) {
        if (this.clientreRepositorie.findById(cliente.getDni()).isPresent()) {
            return null;
        }
        Cliente cliente2 = this.clientreRepositorie.save(cliente);
        if (null != cliente.getCuenta()) {
            for (Cuenta cuenta : cliente.getCuenta()) {
                cuenta.setCliente(cliente2);
                this.cuentaRepositorie.save(cuenta);
            }
        }
        return cliente2;
    }

    @Override
    public List<Cliente> ObtenerCliente() {
        return (List<Cliente>) this.clientreRepositorie.findAll();
    }
    
}
