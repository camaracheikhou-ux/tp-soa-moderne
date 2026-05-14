package fr.ipsl.soa.graphql;

public class Commande {
    private Long id;
    private Long produitId;
    private int quantite;
    private String statut;
    private String date;

    public Commande() {}

    public Long getId()          { return id; }
    public Long getProduitId()   { return produitId; }
    public int getQuantite()     { return quantite; }
    public String getStatut()    { return statut; }
    public String getDate()      { return date; }

    public void setId(Long id)             { this.id = id; }
    public void setProduitId(Long pid)     { this.produitId = pid; }
    public void setQuantite(int q)         { this.quantite = q; }
    public void setStatut(String s)        { this.statut = s; }
    public void setDate(String d)          { this.date = d; }
}
