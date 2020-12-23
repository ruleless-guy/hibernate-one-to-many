package com.alpha.hibernate.controller;

import com.alpha.hibernate.view.View;

import java.io.Serializable;

public interface Controller<MODEL extends Serializable, VIEW extends View<MODEL>> extends View<MODEL>{

    MODEL getModel();
    void setModel(MODEL model);
    VIEW getView();
    void setView(VIEW view);
}
