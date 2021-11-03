package mdla.dara.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Membre implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Column(length = 20)
    private String nom;
    @Column(length = 50)
    private String prenom;
    private String numMbre;
    @Temporal(TemporalType.DATE)
    private Date dateNais;
    private Integer telephone;
    @Column(length = 70)
    private String adresse;
    @Column(length = 10)
    private String sexe;
    private String photoName;
    @Column(nullable = true)
    private String districtOrigine;
    @Column(length = 100)
    @JsonIgnore
    @OneToMany(mappedBy = "membre",cascade = CascadeType.ALL)
    private Collection<Paiement> paiements;
    @JsonIgnore
    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)
    private Collection<Cotisation> cotisations;

    public void add(Paiement paiement) {

        if (paiement != null) {

            if (paiements == null) {
                paiements = new HashSet<>();
            }

            paiements.add(paiement);
            paiement.setMembre(this);
        }
    }
}
