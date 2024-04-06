package hn.unah.lenguajes1900.demo.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes1900.demo.Repositories.CuentaRepositorie;
import hn.unah.lenguajes1900.demo.Repositories.MovimientoRepositorie;
import hn.unah.lenguajes1900.demo.dtos.CrearMovimiento;
import hn.unah.lenguajes1900.demo.entities.Cuenta;
import hn.unah.lenguajes1900.demo.entities.Movimiento;
import hn.unah.lenguajes1900.demo.services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private MovimientoRepositorie movimientoRepositorie;

    @Autowired
    private CuentaRepositorie cuentaRepositorie;

    @Override
    public Movimiento CreaMovimiento(CrearMovimiento crearMovimiento) {

        if (this.cuentaRepositorie.findById(crearMovimiento.getNumCuenta()).isPresent()) {
            Cuenta cuenta = this.cuentaRepositorie.findById(crearMovimiento.getNumCuenta()).get();
            Movimiento movimiento = new Movimiento();
            LocalDateTime fecha = LocalDateTime.now();
            movimiento.setFechamovimiento(Date.valueOf(fecha.toLocalDate()));
            movimiento.setMonto(crearMovimiento.getMonto());
            if (cuenta.getEstado() == 1) {
                if (crearMovimiento.getTipomovimiento() == "D" || crearMovimiento.getTipomovimiento() == "C") {
                    movimiento.setTipomovimiento(crearMovimiento.getTipomovimiento());
                    if (crearMovimiento.getTipomovimiento() == "D") {
                        if (cuenta.getSaldo() > 0) {
                            if (cuenta.getSaldo() < crearMovimiento.getMonto()) {
                                if (cuenta.getSobregiro() == 1) {
                                    cuenta.setSaldo(0.0);
                                    this.cuentaRepositorie.save(cuenta);
                                }
                            }
                        }
                    }
                    if (crearMovimiento.getTipomovimiento() == "C") {
                        cuenta.setSaldo(cuenta.getSaldo() + crearMovimiento.getMonto());
                        this.cuentaRepositorie.save(cuenta);
                        // this.movimientoRepositorie
                    }
                    this.movimientoRepositorie.save(movimiento);
                }
            }
        }

        return null;

    }
    
}
