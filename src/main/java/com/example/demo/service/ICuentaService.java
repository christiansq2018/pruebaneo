package com.example.demo.service;


import com.example.demo.model.Cliente;
import com.example.demo.model.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public interface ICuentaService {

    List<Cuenta> findAll();

    Cuenta findById(Long id);

    Cuenta save(Cuenta cuenta);

    int revisarTotalTransferencias(Long id);

    BigDecimal revisarSaldo(Long cuentaId);

    void transferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal monto,
                    Long id) throws Exception;
}
