package com.example.tp6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int code=- 1 ;

    public static maBaseDeDone db;
    Button ajouter,modifier,supprimer,lister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Room APP");
        db= Room.databaseBuilder(getApplicationContext(),maBaseDeDone.class,"gestProduits").allowMainThreadQueries().build();
        ajouter = findViewById(R.id.Ajout);
        modifier = findViewById(R.id.Modification);
        supprimer = findViewById(R.id.Supprission);
        lister = findViewById(R.id.Lister);
        ajouter.setOnClickListener(this);
        modifier.setOnClickListener( this);
        supprimer.setOnClickListener( this);
        lister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Ajout :
                Intent intent = new Intent(this, AjoutActivity.class);
                startActivity(intent);
                break;
            case R.id.Modification :
                Intent intent2 = new Intent(this, ModifierActivity.class);
                startActivity(intent2);
                break;
            case R.id.Supprission :
                Intent intent3 = new Intent(this, SupprimerActivity.class);
                startActivity(intent3);
                break;
            case R.id.Lister :
                Intent intent4 = new Intent(this, ListerActivity.class);
                startActivity(intent4);
                break;
        }
    }
}