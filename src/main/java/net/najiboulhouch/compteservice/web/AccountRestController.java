package net.najiboulhouch.compteservice.web;

import net.najiboulhouch.compteservice.dtos.VirementRequestDTO;
import net.najiboulhouch.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    private CompteService compteService;

    @PutMapping(path = "compte/virement")
    public void virement(@RequestBody  VirementRequestDTO requestDTO){
        compteService.virement(requestDTO.getCodeSource() , requestDTO.getCodeDestination() , requestDTO.getMontant());
    }
}
