package com.example.projetoihc.Model;

import java.util.Date;

import io.realm.RealmObject;

public class AusenciasAgendadas extends RealmObject {

    private Date data_ausencia;
    private String observacao;
    private Boolean active;

    public Date getData_ausencia() {
        return data_ausencia;
    }

    public void setData_ausencia(Date data_ausencia) {
        this.data_ausencia = data_ausencia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
