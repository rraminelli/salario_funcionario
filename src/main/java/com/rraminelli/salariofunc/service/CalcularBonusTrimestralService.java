package com.rraminelli.salariofunc.service;

import com.rraminelli.salariofunc.model.BonusTrimestral;
import com.rraminelli.salariofunc.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcularBonusTrimestralService implements CalcularSalario {

    private final BigDecimal BONUS_TRIMESTRAL = new BigDecimal(0.1);

    public BigDecimal calcular(Funcionario funcionario) {
        if (funcionario instanceof BonusTrimestral) {
            final long mesesContratacao =
                    ChronoUnit.MONTHS.between(funcionario.getDataContratacao(), LocalDate.now());
            if (mesesContratacao % 3 == 0) {
                return funcionario.getSalario().multiply(BONUS_TRIMESTRAL);
            }
        }

        return BigDecimal.ZERO;
    }

}
