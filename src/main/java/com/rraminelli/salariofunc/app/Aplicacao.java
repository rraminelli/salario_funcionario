package com.rraminelli.salariofunc.app;

import com.rraminelli.salariofunc.model.Coordenador;
import com.rraminelli.salariofunc.model.Funcionario;
import com.rraminelli.salariofunc.model.GerenteProjetos;
import com.rraminelli.salariofunc.model.Programador;
import com.rraminelli.salariofunc.repository.FuncionarioRepository;
import com.rraminelli.salariofunc.service.CalcularSalarioService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {

    private final FuncionarioRepository funcionarioRepository;

    public Aplicacao() {
        funcionarioRepository = new FuncionarioRepository();
        this.iniciarListaFuncionarios();
    }

    public static void main(String[] args) {

        final Aplicacao aplicacao = new Aplicacao();

        final CalcularSalarioService calcularSalarioService =
                new CalcularSalarioService(new ArrayList<>());

        //Lista salarios
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario funcionario : aplicacao.funcionarioRepository.listarTodos()) {
            calcularSalarioService.imprimirSalarioMes(funcionario);
            total = total.add(calcularSalarioService.calcularSalarioMes(funcionario));
        }
        System.out.println(String.format("Total: R$ %.2f", total));


        //Busca por cpf
        Funcionario funcionario = aplicacao.funcionarioRepository.buscarPorId("256312747");
        System.out.println("Busca - " + funcionario.getNome() +
                " - Salario: R$ " + calcularSalarioService.calcularSalarioMes(funcionario));

    }

    void iniciarListaFuncionarios() {

        Funcionario gerenteProjetos1 = new GerenteProjetos();
        gerenteProjetos1.setNome("Gerente Projetos 1");
        gerenteProjetos1.setCpf("256312747");
        gerenteProjetos1.setSalario(new BigDecimal(12_000));
        gerenteProjetos1.setDataContratacao(LocalDate.of(2021, 10, 5));
        funcionarioRepository.salvar(gerenteProjetos1);

        Funcionario gerenteProjetos2 = new GerenteProjetos();
        gerenteProjetos2.setNome("Gerente Projetos 2");
        gerenteProjetos2.setCpf("25412255");
        gerenteProjetos2.setSalario(new BigDecimal(13_500));
        gerenteProjetos2.setDataContratacao(LocalDate.of(2021, 6, 10));
        funcionarioRepository.salvar(gerenteProjetos2);

        Funcionario coordenador1 = new Coordenador();
        coordenador1.setNome("Coordenador 1");
        coordenador1.setCpf("789654123");
        coordenador1.setSalario(new BigDecimal(9_500));
        coordenador1.setDataContratacao(LocalDate.of(2022, 2, 5));
        funcionarioRepository.salvar(coordenador1);

        Funcionario programador1 = new Programador();
        programador1.setNome("Programador 1");
        programador1.setCpf("8541233554");
        programador1.setSalario(new BigDecimal(7_500));
        programador1.setDataContratacao(LocalDate.of(2022, 3, 5));
        funcionarioRepository.salvar(programador1);

        Funcionario programador2 = new Programador();
        programador2.setNome("Programador 2");
        programador2.setCpf("1231233554");
        programador2.setSalario(new BigDecimal(7_000));
        programador2.setDataContratacao(LocalDate.of(2022, 1, 25));
        funcionarioRepository.salvar(programador2);

        Funcionario programador3 = new Programador();
        programador3.setNome("Programador 3");
        programador3.setCpf("4561113554");
        programador3.setSalario(new BigDecimal(7_000));
        programador3.setDataContratacao(LocalDate.of(2021, 9, 25));
        funcionarioRepository.salvar(programador3);

    }

}
