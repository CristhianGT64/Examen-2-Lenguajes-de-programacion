package hn.unah.lenguajes1900.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes1900.demo.entities.Cuenta;

public interface CuentaRepositorie extends CrudRepository<Cuenta,String>{
    
}
