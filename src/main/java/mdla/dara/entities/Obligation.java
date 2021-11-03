package mdla.dara.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Obligation implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private double montant;
}
