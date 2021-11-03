package mdla.dara.services;

import mdla.dara.dao.CotisationRepository;
import mdla.dara.dao.MembreRepository;
import mdla.dara.entities.Cotisation;
import mdla.dara.entities.Membre;
import mdla.dara.entities.ProjectionCotisation;
import mdla.dara.exceptions.MembreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CotisationServiceImpl implements CotisationService{

    private final CotisationRepository cotisationRepository;
    private final MembreRepository membreRepository;
    @Autowired
    public CotisationServiceImpl(CotisationRepository cotisationRepository, MembreRepository membreRepository) {
        this.cotisationRepository = cotisationRepository;
        this.membreRepository = membreRepository;
    }

    @Override
    public Page<Cotisation> cotisationOneMbre(Long id,Pageable pageable) {
        boolean membreNotExists= notMembre(id);
        if(!membreNotExists){
            Page<Cotisation> cotisations= cotisationRepository.findByMembreId(id,pageable);
            return cotisations;
        }else {
            throw new MembreNotFoundException("Membre non trouvé");
       }


    }
    private boolean notMembre(Long id){
        Optional<Membre> membreExists= membreRepository.findById(id);
        if(membreExists.isPresent()){
            return false ;
        }else {
            return true;
        }
    }
}
