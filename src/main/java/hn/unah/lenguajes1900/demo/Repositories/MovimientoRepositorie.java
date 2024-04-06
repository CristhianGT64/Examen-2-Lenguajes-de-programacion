package hn.unah.lenguajes1900.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.core.CrudMethods;

import hn.unah.lenguajes1900.demo.entities.Movimiento;

public interface MovimientoRepositorie extends CrudRepository<Movimiento,Long>{
    
}
