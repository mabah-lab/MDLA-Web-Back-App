package mdla.dara.web;

import mdla.dara.dto.Acquittement;
import mdla.dara.dto.AcquittementResp;
import mdla.dara.services.PaieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AcquittementController {
    private PaieService paieService;

    public AcquittementController(PaieService paieService) {
        this.paieService = paieService;
    }
    @PostMapping("/acquittement")
    public AcquittementResp paie(@RequestBody Acquittement acquittement){
        AcquittementResp acquittementResp= paieService.paie(acquittement);
        return acquittementResp;
    }
}
