package fr.ipsl.soa.graphql;

public class Produit {
    private Long id;
    private String nom;
    private double prix;
    private int stock;

    public Produit() {}

    public Long getId()     { return id; }
    public String getNom()  { return nom; }
    public double getPrix() { return prix; }
    public int getStock()   { return stock; }

    public void setId(Long id)       { this.id = id; }
    public void setNom(String nom)   { this.nom = nom; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setStock(int stock)  { this.stock = stock; }
}
