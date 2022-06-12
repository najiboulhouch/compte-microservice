package net.najiboulhouch.compteservice.service;

import net.najiboulhouch.compteservice.entities.Compte;
import net.najiboulhouch.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    @Autowired
    public CompteRepository compteRepository;

    @Override
    public void virement(Long codeCourse, Long codeDestination, double montant) {

        Compte compteSource = compteRepository.findById(codeCourse).get();
        Compte compteDestination = compteRepository.findById(codeDestination).get();
        compteSource.setSolde(compteSource.getSolde() - montant);
        compteDestination.setSolde(compteDestination.getSolde() + montant);
        compteRepository.save(compteSource);
        compteRepository.save(compteDestination);

    }
}
