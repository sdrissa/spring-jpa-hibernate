package org.formation.sdrissaspringjpahibernate;

import org.formation.sdrissaspringjpahibernate.entities.Produit;
import org.formation.sdrissaspringjpahibernate.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SdrissaSpringJpaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdrissaSpringJpaHibernateApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
     return args -> {
         produitRepository.save(Produit.builder().price(3500).name("computer").quantity(3).build());
         produitRepository.save(Produit.builder().price(15000).name("printer").quantity(2).build());
         produitRepository.save(Produit.builder().price(35800).name("smart phone").quantity(1).build());

         List<Produit> liste=produitRepository.findByNameContainingIgnoreCase("M");
         liste.forEach(y->{
             System.out.println("*************************");
             System.out.println(y.toString());
             System.out.println("*************************");
         });
     };
    }

}
