package fr.ipsl.soa.produits;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final List<Produit> catalogue = List.of(
        new Produit(1L, "Ordinateur portable", 899.99, 15),
        new Produit(2L, "Souris sans fil",     29.90,  80),
        new Produit(3L, "Clavier mecanique",   79.50,  40)
    );

    @GetMapping
    public List<Produit> listerTous() {
        return catalogue;
    }

    @GetMapping("/{id}")
    public Produit trouverParId(@PathVariable Long id) {
        return catalogue.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Produit " + id + " non trouve"));
    }
}
