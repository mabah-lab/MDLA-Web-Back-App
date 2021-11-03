package mdla.dara.dao;

import mdla.dara.entities.Inscription;
import mdla.dara.entities.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
