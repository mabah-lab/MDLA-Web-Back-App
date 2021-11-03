package mdla.dara.services;

import mdla.dara.entities.Membre;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MembreService {
    public List<Membre> getMembres();
    public Membre getOnMembre(Long id);
    public void deleteMembre(Long id);
    public void addMembre(Membre membre);
}
