package mdla.dara.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Cotisation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Double montant;
    private int annee;
    @Column(length = 15)
    private String mois;
    private boolean statut;
    @ManyToOne()
    private Membre membre;
    @ManyToOne
    private Paiement paiement;

}
