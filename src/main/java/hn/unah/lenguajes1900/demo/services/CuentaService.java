package hn.unah.lenguajes1900.demo.services;

import java.security.PublicKey;

import hn.unah.lenguajes1900.demo.entities.Cuenta;

public interface CuentaService {

    public Cuenta CrearCuenta(Cuenta cuenta);

    public Cuenta AsosciarCuentaCliente(String dni, String numCuenta);
    
}
