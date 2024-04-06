package hn.unah.lenguajes1900.demo.services;

import hn.unah.lenguajes1900.demo.dtos.CrearMovimiento;
import hn.unah.lenguajes1900.demo.entities.Movimiento;

public interface MovimientoService {
    public Movimiento CreaMovimiento(CrearMovimiento crearMovimiento);
}
