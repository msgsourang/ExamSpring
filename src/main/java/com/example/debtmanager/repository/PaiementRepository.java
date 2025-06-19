package com.examen.gestiondette.repository;

import com.examen.gestiondette.model.Paiement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Page<Paiement> findByDetteId(Long detteId, Pageable pageable);

    Page<Paiement> findByDetteIdAndDetteClientTelephone(Long detteId, String telephone, Pageable pageable);
}
