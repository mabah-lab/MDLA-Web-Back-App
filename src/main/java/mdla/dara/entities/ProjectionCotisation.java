package mdla.dara.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projCot",types = {mdla.dara.entities.Cotisation.class})
public interface ProjectionCotisation {
    public Long getId();
    public String getAnnee();
    public String getMois();
    public double getMontant();
    public boolean getStatus();
    public Membre getMembre();
    public Paiement getPaiement();
}
