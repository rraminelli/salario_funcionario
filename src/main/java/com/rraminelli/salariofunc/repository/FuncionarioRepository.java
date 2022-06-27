package com.rraminelli.salariofunc.repository;

import com.rraminelli.salariofunc.model.Funcionario;

import java.util.*;

public class FuncionarioRepository implements BaseRepository<Funcionario, String> {

    private final Map<String, Funcionario> listaFuncionario = new HashMap<>();

    @Override
    public Map<String, Funcionario> getDados() {
        return listaFuncionario;
    }
}
