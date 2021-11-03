package mdla.dara.services;

import mdla.dara.entities.Cotisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CotisationService {
    public Page<Cotisation> cotisationOneMbre(Long id,Pageable pageable);
}
