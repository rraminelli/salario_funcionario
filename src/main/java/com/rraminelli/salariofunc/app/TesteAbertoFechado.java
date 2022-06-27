package com.rraminelli.salariofunc.app;

import com.rraminelli.salariofunc.model.Funcionario;
import com.rraminelli.salariofunc.model.GerenteProjetos;
import com.rraminelli.salariofunc.service.CalcularBonusAnualService;
import com.rraminelli.salariofunc.service.CalcularBonusTrimestralService;
import com.rraminelli.salariofunc.service.CalcularSalario;
import com.rraminelli.salariofunc.service.CalcularSalarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TesteAbertoFechado {

    public static void main(String[] args) {

        Funcionario gerenteProjetos1 = new GerenteProjetos();
        gerenteProjetos1.setNome("Gerente Projetos 1");
        gerenteProjetos1.setCpf("256312747");
        gerenteProjetos1.setSalario(new BigDecimal(12_000));
        gerenteProjetos1.setDataContratacao(LocalDate.of(2020, 10, 5));

        List<CalcularSalario> calcularSalarioList = new ArrayList<>();
        calcularSalarioList.add(new CalcularBonusTrimestralService());
        calcularSalarioList.add(new CalcularBonusAnualService());

        CalcularSalarioService calcularSalarioService = new CalcularSalarioService(calcularSalarioList);
        BigDecimal salarioCalculado = calcularSalarioService.calcularSalarioMes(gerenteProjetos1);

        System.out.printf("Salario: %.2f", salarioCalculado);

    }

}
