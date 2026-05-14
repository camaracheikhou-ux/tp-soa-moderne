package fr.ipsl.soa.graphql;

import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class GraphQLController {

    private final ProduitClient produitClient;
    private final CommandeClient commandeClient;

    public GraphQLController(ProduitClient p, CommandeClient c) {
        this.produitClient = p;
        this.commandeClient = c;
    }

    @QueryMapping
    public List<Produit> produits() {
        return produitClient.findAll();
    }

    @QueryMapping
    public Produit produit(@Argument Long id) {
        return produitClient.findById(id);
    }

    @QueryMapping
    public List<Commande> commandes() {
        return commandeClient.findAll();
    }

    @QueryMapping
    public Commande commande(@Argument Long id) {
        return commandeClient.findById(id);
    }

    @SchemaMapping(typeName = "Produit", field = "commandes")
    public List<Commande> commandesDuProduit(Produit produit) {
        return commandeClient.findByProduitId(produit.getId());
    }
}
