package com.alpha.hibernate.view;

import java.io.Serializable;
import java.util.List;

public interface View<MODEL extends Serializable> {
    void printDetails(MODEL model);
    void printDetails(List<MODEL> modelList);
}
