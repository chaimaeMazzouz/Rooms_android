package com.example.tp6;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProduitDAO {
    @Insert
    public void AjouterProdui(Produit p);
    @Update
    public void ModifierProduit(Produit p);
    @Delete
    public void SupprimerProduit(Produit p);
    @Query("select * from Produit")
    public List<Produit> getProduits();
    @Query("select * from Produit where code=:id")
    public Produit getProduitByCode(int id);
}
