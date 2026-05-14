package fr.ipsl.soa.produits;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public List<Produit> listerTous() {
        return produitService.getCatalogue();
    }

    @GetMapping("/{id}")
    public Produit trouverParId(@PathVariable Long id) {
        return produitService.findById(id);
    }
}
