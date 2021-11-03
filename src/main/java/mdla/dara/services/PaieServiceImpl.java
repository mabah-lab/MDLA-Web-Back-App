package mdla.dara.services;

import mdla.dara.dao.CotisationRepository;
import mdla.dara.dao.MembreRepository;
import mdla.dara.dao.PaiementRepository;
import mdla.dara.dto.Acquittement;
import mdla.dara.dto.AcquittementResp;
import mdla.dara.entities.Cotisation;
import mdla.dara.entities.Membre;
import mdla.dara.entities.Paiement;
import mdla.dara.exceptions.MbreAnneeMoisCotisNotFountException;
import mdla.dara.exceptions.MembreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class PaieServiceImpl implements PaieService{
   /* private MembreRepository membreRepository;
    public PaieServiceImpl(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }*/
    private PaiementRepository paiementRepository;
    private MembreRepository membreRepository;
    @Autowired
    private CotisationRepository cotisationRepository;
    @Autowired
    public PaieServiceImpl(PaiementRepository paiementRepository, MembreRepository membreRepository) {
        this.paiementRepository = paiementRepository;
        this.membreRepository = membreRepository;
    }


    @Override
    @Transactional
    public AcquittementResp paie(Acquittement acquittement) {
        // recuperation des paiements du dto
        Paiement paiement = acquittement.getPaiement();


        // generation du numéro de reference
        String paiementRefNumber = generatePaiementRefNumber();
        paiement.setReference(paiementRefNumber);
        paiement.setType(acquittement.getPaiement().getType());

        Membre membre= acquittement.getMembre();
        System.out.printf(acquittement.getMembre().getNumMbre());
        Membre membreDb=membreRepository.findByNumMbre(membre.getNumMbre());
        if(membreDb!=null){
            paiement.setMembre(membreDb);
        }else {
            throw  new MembreNotFoundException("Membre non trouvé") ;
        }


        // lie le paiement avec les cotisations
        Set<Cotisation> cotisations = acquittement.getCotisations();
        cotisations.forEach(cotisation -> {
            boolean notAnneeMoisPaie= notPaie(cotisation.getAnnee(),cotisation.getMois(),membreDb.getId());
            if(notAnneeMoisPaie){
                cotisation.setMembre(membreDb);
                paiement.add(cotisation);
            }else {
                throw new MbreAnneeMoisCotisNotFountException("le mois de "+cotisation.getMois()+" a été dèjà payé par ce membre");
            }
        });

        paiementRepository.save(paiement);

        return new AcquittementResp(paiementRefNumber);
    }
    private boolean notPaie(int annee, String mois, Long membre){
        Cotisation cotisExist= cotisationRepository.findByAnneeAndMoisAndMembreId(annee, mois, membre);
        if(cotisExist==null){
            return true;
        }else {
            return false;
        }

    }

    private String generatePaiementRefNumber() {
        return UUID.randomUUID().toString();
    }
}
