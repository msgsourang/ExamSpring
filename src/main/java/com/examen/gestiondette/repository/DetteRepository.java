package com.examen.gestiondette.repository;

import com.examen.gestiondette.model.Dette;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetteRepository extends JpaRepository<Dette, Long> {
    Page<Dette> findByClientTelephone(String telephone, Pageable pageable);
}
