package com.example.tp6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    List<Produit> donnees;
    Context ctx;
    public ProduitAdapter(List<Produit> donnees,Context ctx){
        this.donnees =donnees;
        this.ctx =ctx;
    }
    @Override
    public int getCount() {
        return donnees.size();
    }

    @Override
    public Object getItem(int position) {
        return donnees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produit pr =donnees.get(position);
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_layout,parent,false);
        }
        TextView code_item= convertView.findViewById(R.id.code_item);
        code_item.setText(String.valueOf(pr.getCode()));
        TextView des_item= convertView.findViewById(R.id.des_item);
        des_item.setText(String.valueOf(pr.getDesignation()));
        TextView pu_item= convertView.findViewById(R.id.pu_item);
        pu_item.setText(String.valueOf(pr.getPrixUnitaire()));

        return convertView;
    }
}
