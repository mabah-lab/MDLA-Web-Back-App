package mdla.dara.dao;

import mdla.dara.entities.Membre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface MembreRepository extends JpaRepository<Membre,Long> {
    public Membre findByTelephone(Integer telephone);
    @RestResource(path = "/byNomPrenomNumMbrePage")
    public Page<Membre>  findByNomContainsOrPrenomContainsOrNumMbreContaining(@Param("mc") String motCle2,@Param("mc") String motCle1,@Param("mc") String motCle,Pageable pageable);
    @RestResource(path="byGenre")
    public Page<Membre> findBySexeIs(@Param("mc") String motCle,Pageable pageable);
    Optional<Membre> findMembreByNumMbre(String numMbre);
    Membre findByNumMbre (String numMbre);
}
