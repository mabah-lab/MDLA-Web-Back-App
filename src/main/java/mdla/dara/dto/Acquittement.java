package mdla.dara.dto;

import lombok.Data;
import mdla.dara.entities.Cotisation;
import mdla.dara.entities.Membre;
import mdla.dara.entities.Paiement;

import java.util.Set;

@Data
public class Acquittement {
    private Membre membre;
    private Set<Cotisation> cotisations;
    private Paiement paiement;

}
