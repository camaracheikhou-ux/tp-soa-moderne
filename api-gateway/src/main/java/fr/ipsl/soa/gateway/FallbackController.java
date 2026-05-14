package fr.ipsl.soa.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/produits")
    public ResponseEntity<Map<String, String>> fallbackProduits() {
        return ResponseEntity.status(503).body(Map.of(
            "erreur",  "Service Produits temporairement indisponible",
            "conseil", "Reessayez dans quelques secondes"
        ));
    }

    @GetMapping("/commandes")
    public ResponseEntity<Map<String, String>> fallbackCommandes() {
        return ResponseEntity.status(503).body(Map.of(
            "erreur",  "Service Commandes temporairement indisponible",
            "conseil", "Reessayez dans quelques secondes"
        ));
    }
}
