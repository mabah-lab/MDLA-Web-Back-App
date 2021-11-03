package mdla.dara.web;

import mdla.dara.entities.Cotisation;
import mdla.dara.services.CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cotis")
public class CotisationRestController {
    private final CotisationService cotisationService;
    @Autowired
    public CotisationRestController(CotisationService cotisationService) {
        this.cotisationService = cotisationService;
    }
    @GetMapping("/cotisationOneMbre/{id}")
    public Page<Cotisation> getCotisOneMbre(@PathVariable("id") Long id,Pageable pageable){
        Page<Cotisation> cotisations=cotisationService.cotisationOneMbre(id,pageable);
        return cotisations;
    }
}
