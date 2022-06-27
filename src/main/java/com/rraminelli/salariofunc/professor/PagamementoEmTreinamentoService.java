package com.rraminelli.salariofunc.professor;

public class PagamementoEmTreinamentoService {

    private PagamentoService pagamentoService;

    public PagamementoEmTreinamentoService(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    void pagar(ProfessorEmTreinamento professorEmTreinamento) {
        pagamentoService.pagar(professorEmTreinamento);
        //adicionar funcionalidades
    }

}
