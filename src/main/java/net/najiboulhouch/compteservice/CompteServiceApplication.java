package net.najiboulhouch.compteservice;

import net.najiboulhouch.compteservice.entities.Compte;
import net.najiboulhouch.compteservice.enums.TypeCompte;
import net.najiboulhouch.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner startApp(CompteRepository compteRepository , RepositoryRestConfiguration restConfiguration){

        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
          compteRepository.save(new Compte(null , 98000, new Date() , TypeCompte.COURANT));
          compteRepository.save(new Compte(null , 12000, new Date() , TypeCompte.EPARGNE));
          compteRepository.save(new Compte(null , 88000, new Date() , TypeCompte.COURANT));
          compteRepository.findAll().forEach(cp -> {
              System.out.println(cp.getType());
              System.out.println(cp.getSolde());
          });
        };
    }
}
