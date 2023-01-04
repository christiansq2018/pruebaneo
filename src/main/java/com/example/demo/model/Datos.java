package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Optional;

public class Datos {


    public static Optional<Cuenta> crearCuenta001() {
        return Optional.of(new Cuenta(1L, "Andres", new BigDecimal("1000")));
    }

    public static Optional<Cuenta> crearCuenta002() {
        return Optional.of(new Cuenta(2L, "Jhon", new BigDecimal("2000")));
    }

    public static Optional<Movimiento> crearBanco() {
        return Optional.of(new Movimiento(1, "movimiento neoris", 0));
    }
}

