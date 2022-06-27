package com.rraminelli.salariofunc.service;

import com.rraminelli.salariofunc.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcularBonusAnualService implements CalcularSalario {

    private final BigDecimal BONUS_ANUAL = new BigDecimal(0.15);

    public BigDecimal calcular(Funcionario funcionario) {
        final long anosContratacao =
                ChronoUnit.YEARS.between(funcionario.getDataContratacao(), LocalDate.now());
        if (anosContratacao >= 1) {
            return funcionario.getSalario().multiply(BONUS_ANUAL);
        }

        return BigDecimal.ZERO;
    }

}
