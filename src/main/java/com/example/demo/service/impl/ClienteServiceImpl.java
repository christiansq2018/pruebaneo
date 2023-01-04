package com.example.demo.service.impl;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    @Operation(summary = "lista todos los cliente")
    @Transactional
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }



    @Override
    @Operation(summary = "Encuentra un cliente por id")
    @Transactional
    public Cliente buscarPorIdCliente(Long idCliente) throws Exception{
        return clienteRepository.buscarPorIdCliente(idCliente);
        }

    @Override
    @Operation(summary = "Guarda los parametros del cliente")
    @Transactional
    public Cliente save(Cliente cliente) throws Exception{

        return clienteRepository.save(cliente);
    }


    @Operation(summary = "Modifica los parametros del cliente")
    @Transactional
    public Cliente modificar(Cliente cliente) throws Exception{

        return clienteRepository.save(cliente);
    }

    @Override
    @Operation(summary = "Elimina un cliente por id")
    @Transactional
    public void deleteById(Long idCliente) throws Exception {
        clienteRepository.deleteById(idCliente);

    }


}
