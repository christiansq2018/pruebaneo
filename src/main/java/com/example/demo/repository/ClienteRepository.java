package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    List<Cliente> findAll();

    @Query("SELECT c FROM Cliente c WHERE c.idCliente = :idcliente ")
    Cliente buscarPorIdCliente(@Param("idcliente") Long idCliente);

    Cliente save(Cliente cliente);

    void deleteById(Long idCliente);
}
