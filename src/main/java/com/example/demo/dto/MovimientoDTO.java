package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MovimientoDTO {

        private Long cuentaOrigenId;
        private Long cuentaDestinoId;
        private BigDecimal monto;
        private Long movimientoId;


}
