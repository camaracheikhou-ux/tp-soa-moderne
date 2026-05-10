package fr.ipsl.soa.commandes;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final List<Commande> commandes = List.of(
        new Commande(1L, 1L, 2, "LIVREE",   LocalDate.of(2025, 3, 10)),
        new Commande(2L, 2L, 5, "EN_COURS", LocalDate.of(2025, 4,  1)),
        new Commande(3L, 3L, 1, "ANNULEE",  LocalDate.of(2025, 4,  5))
    );

    @GetMapping
    public List<Commande> listerToutes() {
        return commandes;
    }

    @GetMapping("/{id}")
    public Commande trouverParId(@PathVariable Long id) {
        return commandes.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Commande " + id + " non trouvee"));
    }

    @GetMapping("/produit/{produitId}")
    public List<Commande> parProduit(@PathVariable Long produitId) {
        return commandes.stream()
            .filter(c -> c.getProduitId().equals(produitId))
            .toList();
    }
}
