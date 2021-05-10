package com.example.projetoihc.Model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Users extends RealmObject {

    @PrimaryKey
    private String user_id;    //cartao ufrgs
    private String user_name;
    private String user_password;
    private RealmList<Presencas> lista_presenca;
    private RealmList<AusenciasAgendadas> lista_ausencias;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public List<Presencas> getLista_presenca() {
        return lista_presenca;
    }

    public void setLista_presenca(RealmList<Presencas> lista_presenca) {
        this.lista_presenca = lista_presenca;
    }

    public List<AusenciasAgendadas> getLista_ausencias() {
        return lista_ausencias;
    }

    public void setLista_ausencias(RealmList<AusenciasAgendadas> lista_ausencias) {
        this.lista_ausencias = lista_ausencias;
    }
}
