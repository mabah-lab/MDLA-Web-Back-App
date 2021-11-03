package mdla.dara.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@Projection(name = "projMbre",types = {mdla.dara.entities.Membre.class})
public interface ProjectionMembre {
    public Long getId();
    public String getNom();
    public String getPrenom();
    public Date getDateNais();
    public List<Cotisation> getCotisations();
}
