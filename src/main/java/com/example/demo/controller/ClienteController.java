package com.example.demo.controller;

import com.example.demo.exception.ModeloNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.service.impl.ClienteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/clientes")
@RestController
@Slf4j
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceimpl;


    @PostMapping
    @Operation(description = "Metodo que guarda cliente",
            summary = "Guardar cliente.")
    public ResponseEntity<Cliente> guardarCliente(@Valid @RequestBody Cliente cliente) throws Exception {
        Cliente obj = clienteServiceimpl.buscarPorIdCliente(cliente.getIdCliente());
        if(obj != null) {
            throw new ModeloNotFoundException("Ya existe Cliente con este número de id : " + cliente.getIdCliente());
        }else {
            obj = clienteServiceimpl.save(cliente);

        }

        return  new ResponseEntity<Cliente>(obj , CREATED);
    }

    @GetMapping
    @Operation(description = "Metodo que lista  los clientes",
            summary = "Listar cliente.")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> listacliente = clienteServiceimpl.findAll();
        return new ResponseEntity<List<Cliente>>(listacliente, OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Metodo que busca un cliente por id",
            summary = "Encontrar cliente por id.")
    public ResponseEntity<Cliente> ClientePorId(@PathVariable Long id) throws Exception {
        Cliente obj = clienteServiceimpl.buscarPorIdCliente(id);
        if(obj == null) {
            throw new ModeloNotFoundException("No existe Cliente con este número de id : " + id);
        }
         obj = clienteServiceimpl.buscarPorIdCliente(id);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @PutMapping
    @Operation(description = "Metodo que actualiza un cliente por id",
            summary = "Encontrar cliente por id y actualizarlo")
    public ResponseEntity<Cliente> modificarCliente(@Valid @RequestBody Cliente cliente) throws Exception {
       Cliente obj = clienteServiceimpl.buscarPorIdCliente(cliente.getIdCliente());
       if (obj == null) {
           throw new ModeloNotFoundException("No existe Cliente con este número de id, puede crearlo : " + cliente.getIdCliente());
       } else {
           obj = clienteServiceimpl.modificar(cliente);
           return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
       }
   }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) throws Exception{
        Cliente obj = clienteServiceimpl.buscarPorIdCliente(id);
        if(obj == null) {
            throw new ModeloNotFoundException("No existe Cliente con este número de id : " + id);
        }
        clienteServiceimpl.deleteById(id);
        return  new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
