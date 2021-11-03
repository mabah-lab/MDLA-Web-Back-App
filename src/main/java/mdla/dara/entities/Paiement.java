package mdla.dara.entities;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Date date;
    private Double montant;
    @Column(length = 15)
    private String type;
    @Column(unique = false)
    private String reference;
    @ManyToOne
    private Membre membre;

    @OneToMany(mappedBy = "paiement", cascade = CascadeType.ALL)
    private Set<Cotisation> cotisations = new HashSet<>();
    public void add(Cotisation cotis){
        if(cotis!=null){
            if(cotisations==null){
                cotisations= new HashSet<>();
            }
            cotisations.add(cotis);
            cotis.setPaiement(this);
        }
    }

}
