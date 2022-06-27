package com.rraminelli.salariofunc.model;

import com.rraminelli.salariofunc.annotations.PK;

public class Endereco extends BaseModel<Long> {

    private Long id;

    private String endereco;
    private String cep;
    private String cidade;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
