package fr.ipsl.soa.graphql;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ProduitClient {

    private final RestTemplate rest = new RestTemplate();
    private static final String BASE = "http://localhost:8081/produits";

    public List<Produit> findAll() {
        Produit[] arr = rest.getForObject(BASE, Produit[].class);
        return arr == null ? List.of() : Arrays.asList(arr);
    }

    public Produit findById(Long id) {
        return rest.getForObject(BASE + "/" + id, Produit.class);
    }
}
