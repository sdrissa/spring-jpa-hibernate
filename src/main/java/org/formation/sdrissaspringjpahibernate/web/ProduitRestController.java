package org.formation.sdrissaspringjpahibernate.web;

import org.formation.sdrissaspringjpahibernate.entities.Produit;
import org.formation.sdrissaspringjpahibernate.repositories.ProduitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduitRestController {

    private ProduitRepository produitRepository;

    public ProduitRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @GetMapping("/produits")
    public List<Produit> liste(){
       return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Produit getProduit(@PathVariable Long id){
        return produitRepository.findById(id).get();
    }

}
