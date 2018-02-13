package com.bkolomiets;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class GrowlView {
    public void info() {
        FacesContext.getCurrentInstance()
                .addMessage("info", new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "Info", "Введите количество чашек."));
    }
}
