package com.examen.gestiondette.service;

import com.examen.gestiondette.model.Dette;
import com.examen.gestiondette.model.Paiement;
import com.examen.gestiondette.repository.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final DetteService detteService;

    public Paiement ajouterPaiement(Long detteId, Paiement paiement) {
        Dette dette = detteService.getDette(detteId);
        paiement.setDette(dette);
        return paiementRepository.save(paiement);
    }

    public Page<Paiement> listerPaiements(Long detteId, String telephone, Pageable pageable) {
        if (telephone != null && !telephone.isBlank()) {
            return paiementRepository.findByDetteIdAndDetteClientTelephone(detteId, telephone, pageable);
        }
        return paiementRepository.findByDetteId(detteId, pageable);
    }
}
