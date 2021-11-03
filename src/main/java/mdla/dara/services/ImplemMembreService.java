package mdla.dara.services;

import mdla.dara.dao.MembreRepository;
import mdla.dara.entities.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImplemMembreService implements  MembreService{
    @Autowired
    private  MembreRepository membreRepository;

    @Override
    public List<Membre> getMembres() {
        List<Membre> membres =membreRepository.findAll();
        if(membres.isEmpty()){
            throw new IllegalStateException("Aucun membre disponible dans la base de données");
        } else {
            return membres;
        }

    }

    @Override
    public Membre getOnMembre(Long id) {
        boolean membreExist= membreRepository.findById(id).isPresent();
        if(!membreExist)
            throw new IllegalStateException("Membre non trouvé");
        Membre membre= membreRepository.findById(id).get();
        return membre;
    }

    @Override
    public void deleteMembre(Long id) {
        boolean membreExist= membreRepository.findById(id).isPresent();
        if(!membreExist)
            throw new IllegalStateException("Membre non trouvé");
        membreRepository.deleteById(id);

    }

    @Override
    public void addMembre(Membre membre) {
        Optional<Membre> membreOptional=membreRepository.findMembreByNumMbre(membre.getNumMbre());
        if( membreOptional.isPresent()) {
            throw new IllegalStateException("Cet membre existe dèjà");
        }
        membreRepository.save(membre);
    }

}
