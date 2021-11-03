package mdla.dara.web;

import mdla.dara.dao.CotisationRepository;
import mdla.dara.dao.MembreRepository;
import mdla.dara.entities.Cotisation;
import mdla.dara.entities.Membre;
import mdla.dara.entities.ProjectionCotisation;
import mdla.dara.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@CrossOrigin("*")
public class MdlaRestController {
    @Autowired
    MembreRepository membreRepository;
    @Autowired
    CotisationRepository cotisationRepository;
    private MembreService membreService ;

    @GetMapping(path = "/cotisationMembre/{id}")
    public List<Cotisation> cotisationMembre(@PathVariable(name="id") Long id){
        Membre membre= new Membre();
        membre= membreRepository.findById(id).get();
        List<Cotisation> cotisations= new ArrayList<>();
        ProjectionCotisation projectionCotisation;
        return cotisations;
    }
    @GetMapping(path = "/getOneMembre/{id}")
    public Membre getMembre(@PathVariable(name = "id") Long id){
        return  membreService.getOnMembre(id);

    }
}
