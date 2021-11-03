package mdla.dara.services;

import mdla.dara.dto.Acquittement;
import mdla.dara.dto.AcquittementResp;
import mdla.dara.entities.Cotisation;

import java.util.List;

public interface PaieService {
    AcquittementResp paie(Acquittement acquittement);

}
