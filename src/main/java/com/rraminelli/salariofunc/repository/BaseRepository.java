package com.rraminelli.salariofunc.repository;

import com.rraminelli.salariofunc.model.BaseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface BaseRepository<T extends BaseModel<ID> & Comparable<T>, ID> {

    Map<ID, T> getDados();

    default void salvar(T model) {
        getDados().put(model.getId(), model);
    }

    default List<T> listarTodos() {
        final List<T> lista = new ArrayList<>(getDados().values());
        Collections.sort(lista);
        return lista;
    }

    default T buscarPorId(ID id) {
        return getDados().get(id);
    }

}
