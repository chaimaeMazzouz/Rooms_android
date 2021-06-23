package com.example.tp6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produit {
    @PrimaryKey (autoGenerate = true)
    private int code;
    private String designation;
    @ColumnInfo(name = "prix_unitaire")
    private double prixUnitaire;

    public Produit()
    { }
    public Produit(int code, String designation, double prixUnitaire) {
        this.code = code;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) { this.designation = designation; } public double getPrixUnitaire() { return prixUnitaire; } public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; } @Override

    public String toString() { return "code=" + code + ", designation='" + designation + '\'' + ", prixUnitaire=" + prixUnitaire + '\n'; }
}
