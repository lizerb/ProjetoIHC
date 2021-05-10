package com.example.projetoihc.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projetoihc.Model.Presencas;
import com.example.projetoihc.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Presencas> presencas;

    public CustomAdapter(Context c, ArrayList<Presencas> presencas) {
        this.c = c;
        this.presencas = presencas;
    }

    @Override
    public int getCount() {
        return presencas.size();
    }

    @Override
    public Object getItem(int position) {
        return presencas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtDataPresenca;
        txtDataPresenca = view.findViewById(R.id.listPresencas);

        Presencas p = (Presencas) this.getItem(position);
        txtDataPresenca.setText(p.getData_presenca());

        return view;
    }
}
