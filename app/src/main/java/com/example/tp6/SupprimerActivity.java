package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SupprimerActivity extends AppCompatActivity {

    EditText etCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        setTitle("Room Supprimer Produit");
        etCode = findViewById(R.id.NumP_Sup);
    }
    public void Supprimer_Produit(View v)
    {
        if(TextUtils.isEmpty(etCode.getText().toString())){
            Toast.makeText(this,"Le numéro est obligatoire",Toast.LENGTH_LONG).show();
            return;
        }
        int code=Integer.parseInt(etCode.getText().toString());
        Produit pr=new Produit();
        pr.setCode(code);
        Produit p=MainActivity.db.produitDao().getProduitByCode(code);

        if(p==null) {
            Toast.makeText(this,"Produit introuvable",Toast.LENGTH_LONG).show();
        return;
        }
        MainActivity.db.produitDao().SupprimerProduit(pr);
        Toast.makeText(this,"Produit supprimé",Toast.LENGTH_LONG).show();

    }
    public void  Menu_back(View v){finish();}
}