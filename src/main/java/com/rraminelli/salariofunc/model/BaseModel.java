package com.rraminelli.salariofunc.model;

import com.rraminelli.salariofunc.annotations.PK;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseModel<ID> {

    public ID getId() {
        try {
            List<Field> fields = getAllFields(this.getClass());
            for (Field field : fields) {
                if (field.isAnnotationPresent(PK.class)) {
                    field.setAccessible(true);
                    return (ID) field.get(this);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Field> getAllFields(Class clazz) {
        List<Field> fields = new ArrayList<>();

        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        if (clazz.getSuperclass() != null) { //Recupera os atributos das classes super
            fields.addAll(getAllFields(clazz.getSuperclass())); //Chamada Recursiva
        }

        return fields;
    }

}
