package com.rraminelli.salariofunc.service;

import com.rraminelli.salariofunc.model.BonusTrimestral;
import com.rraminelli.salariofunc.model.Funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class CalcularSalarioService {

    private List<CalcularSalario> calcularSalarioList;

    public CalcularSalarioService(List<CalcularSalario> calcularSalarioList) {
        this.calcularSalarioList = calcularSalarioList;
    }

    public BigDecimal calcularSalarioMes(Funcionario funcionario) {

        BigDecimal salario = funcionario.getSalario();

        for (CalcularSalario calcularSalario : calcularSalarioList) {
            BigDecimal bonus = calcularSalario.calcular(funcionario);
            salario = salario.add(bonus);
        }

        return salario;

    }

    public void imprimirSalarioMes(Funcionario funcionario) {
        final BigDecimal salarioMes = calcularSalarioMes(funcionario);

        final DecimalFormat df = new DecimalFormat("#,###.00");

        final StringBuilder salarioStr = new StringBuilder()
                .append(String.format("%s - R$ %s", funcionario.getNome(), df.format(salarioMes)));

        if (salarioMes.compareTo(funcionario.getSalario()) != 0) {
            salarioStr.append(" * ");
        }

        System.out.println(salarioStr);
    }

}
