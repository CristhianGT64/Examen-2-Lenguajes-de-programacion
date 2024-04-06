package hn.unah.lenguajes1900.demo.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.demo.Repositories.ClientreRepositorie;
import hn.unah.lenguajes1900.demo.Repositories.CuentaRepositorie;
import hn.unah.lenguajes1900.demo.Repositories.MovimientoRepositorie;
import hn.unah.lenguajes1900.demo.entities.Cliente;
import hn.unah.lenguajes1900.demo.entities.Cuenta;
import hn.unah.lenguajes1900.demo.entities.Movimiento;
import hn.unah.lenguajes1900.demo.services.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepositorie cuentaRepositorie;

    @Autowired
    private MovimientoRepositorie movimientoRepositorie;

    @Autowired
    private ClientreRepositorie clientreRepositorie;

    @Override
    public Cuenta CrearCuenta(Cuenta cuenta) {
        LocalDateTime fecha = LocalDateTime.now();
        Date FechaActual = Date.valueOf(fecha.toLocalDate());
        cuenta.setFechaapertura(FechaActual);
        cuenta.setEstado(1);
        if (cuenta.getSaldo() > 500) {
            if (this.cuentaRepositorie.findById(cuenta.getNumerocuenta()).isPresent()) {
                return null;
            }
            Cuenta cuenta2 = this.cuentaRepositorie.save(cuenta);
            if (null != cuenta.getMovimiento()) {
                for (Movimiento movimiento : cuenta.getMovimiento()) {
                    movimiento.setCuenta(cuenta2);
                    this.movimientoRepositorie.save(movimiento);
                }
            }
            return cuenta2;
        }
        return null;
    }

    @Override
    public Cuenta AsosciarCuentaCliente(String dni, String numCuenta) {
        if (this.clientreRepositorie.findById(dni).isPresent()) {
            if (this.cuentaRepositorie.findById(numCuenta).isPresent()) {
                Cliente cliente = this.clientreRepositorie.findById(dni).get();
                Cuenta cuenta = this.cuentaRepositorie.findById(numCuenta).get();
                cuenta.setCliente(cliente);
                return this.cuentaRepositorie.save(cuenta);
            }
        }
        return null;
    }
    
}
