package com.example.projetoihc.MyHelper;

import com.example.projetoihc.Model.Presencas;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyHelper {
    Realm realm;
    RealmResults<Presencas> presencas;

    public MyHelper(Realm realm) {
        this.realm = realm;
    }

    public void selectFromDB(){
        presencas = realm.where(Presencas.class).findAll();
    }

    public ArrayList<Presencas> justRefresh(){
        ArrayList<Presencas> listItem = new ArrayList<>();
        for(Presencas p: presencas){
            listItem.add(p);
        }
        return listItem;
    }
}
