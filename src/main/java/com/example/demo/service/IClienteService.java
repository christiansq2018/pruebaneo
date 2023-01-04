package com.example.demo.service;

import com.example.demo.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IClienteService {

    List<Cliente> findAll();


    Cliente buscarPorIdCliente(Long idCliente) throws Exception;

    Cliente save(Cliente cliente) throws Exception;


    void deleteById(Long idCliente) throws Exception;
}
