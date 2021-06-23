package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ModifierActivity extends AppCompatActivity {
    EditText etCode,etDestignation,etPUc;
    private int code=- 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        setTitle("Room Modifier Produit");
        etCode = findViewById(R.id.NumP_Mod);
        etDestignation = findViewById(R.id.Des_Mod);
        etPUc = findViewById(R.id.PrixU_Mod);
    }
    public void Modifier_Produit(View v)
    {
        if(code==-1){
            Toast.makeText(this,"Rechercher le produit",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(etDestignation.getText().toString())){
            Toast.makeText(this,"La désignation est obligatoire",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(etPUc.getText().toString())){
            Toast.makeText(this,"Le prix unitaire est obligatoire",Toast.LENGTH_LONG).show();
            return;
        }
        String des=etDestignation.getText().toString();
        Double pu=Double.parseDouble(etPUc.getText().toString());
        Produit p=new Produit();
        p.setCode(code);
        p.setDesignation(des);
        p.setPrixUnitaire(pu);
        MainActivity.db.produitDao().ModifierProduit(p);
        etCode.setText("");
        etPUc.setText("");
        etDestignation.setText("");
        Toast.makeText(this,"Produit modifie",Toast.LENGTH_LONG).show();
    }
    public void Rechercher(View v){
        if(TextUtils.isEmpty(etCode.getText().toString())){
            Toast.makeText(this,"Le numéro est obligatoire",Toast.LENGTH_LONG).show();
            return;
        }
        code=Integer.parseInt(etCode.getText().toString());
        Produit pr= MainActivity.db.produitDao().getProduitByCode(code);
        if(pr!=null){ etDestignation.setText(pr.getDesignation());
        etPUc.setText(String.valueOf(pr.getPrixUnitaire()));
        }
        else
           Toast.makeText(this,"Produit introuvable",Toast.LENGTH_LONG).show();
    }
    public void  Menu_back(View v){finish();}
}