package hn.unah.lenguajes1900.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes1900.demo.entities.Direccion;

// import jakarta.persistence.Entity;
// import lombok.Data;

public interface DireccionRepositorie extends CrudRepository<Direccion,Long>{
    
}
