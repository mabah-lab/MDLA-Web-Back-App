package mdla.dara.services;

import mdla.dara.dao.*;
import mdla.dara.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ClientInfoStatus;
import java.util.*;

@Service
@Transactional
public class ImplemInitService implements InitialisationService{
    @Autowired
    MembreRepository membreRepository;
    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    CotisationRepository cotisationRepository;
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    ObligationRepository obligationRepository;

    @Override
    public void initMdla() {
        Obligation obligation= obligationRepository.save(new Obligation(null,new Date(),null,5.0));

        Membre m1= membreRepository.save(new Membre(null,"bah","mamadou","D001",new Date(),025436661,"rue dAnderlecht 75, 1000 Bruxelles","Homme","unknownAvatar",null,null,null));
        Membre m2= membreRepository.save(new Membre(null,"Diallo","Lamarana","D002",new Date(),025632546,"rue lefranc 3, 1030 Bruxelles","Homme" ,"unknownAvatar",null,null,null));
        Membre m3= membreRepository.save(new Membre(null,"Sow","oumou","D003",new Date(),025431756,"avenue bailli 8, 1050 Ixelles","Femme","unknownAvatar",null,null,null));

        Inscription i1= inscriptionRepository.save(new Inscription(null,new Date(),"actif",m1));
        Inscription i2= inscriptionRepository.save(new Inscription(null,new Date(),"actif",m2));
        Inscription i3= inscriptionRepository.save(new Inscription(null,new Date(),"actif",m2));

        Paiement p1= paiementRepository.save(new Paiement(null,new Date(),10.0,"cotisation",UUID.randomUUID().toString(),m1,null));
        Paiement p2= paiementRepository.save(new Paiement(null,new Date(),5.0,"cotisation",UUID.randomUUID().toString(),m3,null ));

        Cotisation c1=cotisationRepository.save(new Cotisation(null,5.0,2020,"Janvier",true,m1,p1));
        Cotisation c2=cotisationRepository.save(new Cotisation(null,5.0,2020,"Fevrier",true,m1,p1));
        Cotisation c3=cotisationRepository.save(new Cotisation(null,5.0,2020,"Mars",true,m1,p1));
        Cotisation c4=cotisationRepository.save(new Cotisation(null,5.0,2020,"Janvier",true,m3,p2));

       /* Page<Cotisation> cotis= cotisationRepository.findByMembreId(m3.getId(),null);
        cotis.forEach(c->{
            System.out.println(c.toString());
        });*/

    }


}
