package mdla.dara.dao;

import mdla.dara.entities.Cotisation;
import mdla.dara.entities.Membre;
import mdla.dara.entities.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface CotisationRepository extends JpaRepository<Cotisation,Long> {
    @RestResource(path = "/byMembre")
    public Page<Cotisation> findByMembreId(@Param("idMbre") Long idMembre,Pageable pageable);
    public Page<Cotisation> findByAnnee(String annee, Pageable pageable);
    @RestResource(path = "/byAnneeMoisMbre")
    public Cotisation findByAnneeAndMoisAndMembreId(@Param("a") int annee,@Param("m")String mois,@Param("mb")Long membre);
    @RestResource(path = "/lastCotisByMbreId")
    public Cotisation findTopAndByMembreIdOrderByIdDesc(@Param("idMbre") Long idMbre);

}
