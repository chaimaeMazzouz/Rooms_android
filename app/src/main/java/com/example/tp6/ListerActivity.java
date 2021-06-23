package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class ListerActivity extends AppCompatActivity {

    List<Produit> donnees;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);
        setTitle("Liste Produits");
        list =findViewById(R.id.liste);
        actualiser();
        ProduitAdapter adapter = new ProduitAdapter(donnees,this);
        list.setAdapter(adapter);
    }
    private  void  actualiser(){
        donnees =MainActivity.db.produitDao().getProduits();
    }
}