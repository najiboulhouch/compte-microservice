package net.najiboulhouch.compteservice.service;

public interface CompteService {
     void virement(Long codeCourse , Long codeDestination , double montant);
}
