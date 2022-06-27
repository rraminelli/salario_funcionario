package com.rraminelli.salariofunc.professor;

public class TestePagamentoProfessor {

    public static void main(String[] args) {

        PagamentoService pagamentoService = new PagamentoService();
        pagamentoService.pagar(new Professor());
        pagamentoService.pagar(new ProfessorEmTreinamento());

        PagamementoEmTreinamentoService pagamentoEmTreinamento = new PagamementoEmTreinamentoService(pagamentoService);
        pagamentoEmTreinamento.pagar(new ProfessorEmTreinamento());

    }

}
