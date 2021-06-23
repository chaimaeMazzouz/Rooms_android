package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutActivity extends AppCompatActivity {

    EditText etCode,etDestignation,etPUc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        setTitle("Room Ajouter Produit");
        etCode = findViewById(R.id.NumP);
        etDestignation = findViewById(R.id.Des);
        etPUc = findViewById(R.id.PrixU);
    }
    public void Ajouter_Produit(View v){
        if(TextUtils.isEmpty(etCode.getText().toString())){
            Toast.makeText(this,"Le numéro est obligatoire", Toast.LENGTH_LONG).show();
            return; }
        if(TextUtils.isEmpty(etDestignation.getText().toString())){
            Toast.makeText(this,"La désignation est obligatoire",Toast.LENGTH_LONG).show();
            return; } if(TextUtils.isEmpty(etPUc.getText().toString())){

            Toast.makeText(this,"prix unitaire obligatoire",Toast.LENGTH_LONG).show();
            return; }
        int code=Integer.parseInt(etCode.getText().toString());
        String des=etDestignation.getText().toString();
        Double pu=Double.parseDouble(etPUc.getText().toString());
        Produit pr=new Produit(); pr.setCode(code); pr.setDesignation(des);
        pr.setPrixUnitaire(pu); MainActivity.db.produitDao().AjouterProdui(pr);
        etCode.setText("");
        etPUc.setText("");
        etDestignation.setText("");
        Toast.makeText(this,"Produit ajouté",Toast.LENGTH_LONG).show();
    }
}