package com.example.projetoihc.Model;

import io.realm.RealmObject;

public class Presencas extends RealmObject {

    private String data_presenca;

    public String getData_presenca() {
        return data_presenca;
    }

    public void setData_presenca(String data_presenca) {
        this.data_presenca = data_presenca;
    }
}
