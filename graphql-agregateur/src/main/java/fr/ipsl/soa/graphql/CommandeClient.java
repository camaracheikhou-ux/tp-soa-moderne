package fr.ipsl.soa.graphql;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandeClient {

    private final RestTemplate rest = new RestTemplate();
    private static final String BASE = "http://localhost:8082/commandes";

    public List<Commande> findAll() {
        Commande[] arr = rest.getForObject(BASE, Commande[].class);
        return arr == null ? List.of() : Arrays.asList(arr);
    }

    public Commande findById(Long id) {
        return rest.getForObject(BASE + "/" + id, Commande.class);
    }

    public List<Commande> findByProduitId(Long produitId) {
        Commande[] arr = rest.getForObject(BASE + "/produit/" + produitId, Commande[].class);
        return arr == null ? List.of() : Arrays.asList(arr);
    }
}
