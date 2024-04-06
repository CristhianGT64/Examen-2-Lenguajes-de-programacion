package hn.unah.lenguajes1900.demo.dtos;

import lombok.Data;

@Data
public class CrearMovimiento {
    private String numCuenta;

    private String tipomovimiento;

    private Float monto;
}
