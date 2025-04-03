package org.formation.sdrissaspringjpahibernate.repositories;

import org.formation.sdrissaspringjpahibernate.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    List<Produit> findByNameContainingIgnoreCase(String name);

    List<Produit> findByNameContainsAndPriceGreaterThan(String name, double price);

    @Query("select p from Produit p where p.name like :name and p.price>:price")
    List<Produit> search(@Param("name") String name,@Param("price") double price );
}
