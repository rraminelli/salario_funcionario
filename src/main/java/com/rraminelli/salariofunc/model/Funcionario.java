package com.rraminelli.salariofunc.model;

import com.rraminelli.salariofunc.annotations.PK;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Funcionario extends BaseModel<String> implements Comparable<Funcionario> {

    @PK
    private String cpf;
    private String nome;
    private BigDecimal salario;
    private LocalDate dataContratacao;

    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(salario, that.salario) && Objects.equals(dataContratacao, that.dataContratacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, salario, dataContratacao);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", salario=").append(salario);
        sb.append(", dataContratacao=").append(dataContratacao);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        return this.getNome().compareTo(funcionario.getNome());
    }
}
