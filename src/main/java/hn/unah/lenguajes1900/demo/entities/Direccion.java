package hn.unah.lenguajes1900.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

// import org.springframework.data.jpa.repository.query.JpqlParser.Single_valued_object_path_expressionContext;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
// import jakarta.persistence.TableGenerator;
import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iddireccion")
    private Long iddireccion;

    private String estado;

    private String ciudad;

    private String calle;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente cliente;


    
}
