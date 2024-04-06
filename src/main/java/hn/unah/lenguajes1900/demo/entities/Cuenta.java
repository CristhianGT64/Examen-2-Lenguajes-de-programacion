package hn.unah.lenguajes1900.demo.entities;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(name = "numerocuenta")
    private String numerocuenta;

    private Double saldo;

    private Date fechaapertura;

    private Integer estado;

    private Integer sobregiro;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;

    @OneToMany
    private List<Movimiento> movimiento;

}
