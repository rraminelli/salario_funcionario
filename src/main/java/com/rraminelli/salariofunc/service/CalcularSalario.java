package com.rraminelli.salariofunc.service;

import com.rraminelli.salariofunc.model.Funcionario;

import java.math.BigDecimal;

public interface CalcularSalario {

    BigDecimal calcular(Funcionario funcionario);

}
