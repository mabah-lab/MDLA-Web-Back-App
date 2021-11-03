package mdla.dara.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Inscription implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Date dateIns;
    @Column(length = 10)
    private String statut;
    @ManyToOne
    private Membre membre;
}
