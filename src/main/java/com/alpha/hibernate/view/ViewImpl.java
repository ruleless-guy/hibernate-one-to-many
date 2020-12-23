package com.alpha.hibernate.view;

import java.io.Serializable;
import java.util.List;

public abstract class ViewImpl<MODEL extends Serializable> implements View<MODEL> {

    @Override
    public void printDetails(List<MODEL> modelList) {
        for(MODEL model : modelList ){
            printDetails(model);
        }
    }
}
