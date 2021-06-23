package com.example.tp6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Produit.class},version = 1)
public abstract class maBaseDeDone extends RoomDatabase {
    public abstract ProduitDAO produitDao();
}
