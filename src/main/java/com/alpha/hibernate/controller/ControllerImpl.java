package com.alpha.hibernate.controller;

import com.alpha.hibernate.view.View;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class ControllerImpl<MODEL extends Serializable, VIEW extends View<MODEL>> implements Controller<MODEL, VIEW> {

    private MODEL model;
    private VIEW view;

    @SuppressWarnings("unchecked")
    public ControllerImpl(){
        Class<MODEL> modelClass = (Class<MODEL>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<VIEW> viewClass = (Class<VIEW>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        model = getInstance(modelClass);
        view = getInstance(viewClass);
    }

    private <T> T getInstance(Class<T> typeClass){
        try {
            return typeClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MODEL getModel() {
        return model;
    }

    @Override
    public void setModel(MODEL model) {
        this.model = model;
    }

    @Override
    public VIEW getView() {
        return view;
    }

    @Override
    public void setView(VIEW view) {
        this.view = view;
    }
}
