package net.najiboulhouch.compteservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import net.najiboulhouch.compteservice.enums.TypeCompte;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compte {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long code ;
    private double solde;
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
