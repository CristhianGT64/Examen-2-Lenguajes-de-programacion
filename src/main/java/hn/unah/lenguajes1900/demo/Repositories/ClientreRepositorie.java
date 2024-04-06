package hn.unah.lenguajes1900.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes1900.demo.entities.Cliente;

public interface ClientreRepositorie extends CrudRepository<Cliente,String>{
    
}
