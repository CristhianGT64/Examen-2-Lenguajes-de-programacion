package hn.unah.lenguajes1900.demo.entities;

import java.util.List;

import org.hibernate.annotations.Collate;
import org.hibernate.query.sqm.CastType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @Column(name = "dni")
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    @OneToOne
    private Direccion direccion;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cuenta> cuenta;

}
