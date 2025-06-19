package com.examen.gestiondette.controller;

import com.examen.gestiondette.model.Paiement;
import com.examen.gestiondette.service.PaiementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping("/dettes/{detteId}/paiements")
    public ResponseEntity<Paiement> ajouterPaiement(@PathVariable Long detteId, @Valid @RequestBody Paiement paiement) {
        Paiement saved = paiementService.ajouterPaiement(detteId, paiement);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    
    @GetMapping("/dettes/{detteId}/paiements")
    public Page<Paiement> listerPaiements(@PathVariable Long detteId,
                                          @RequestParam(required = false) String telephone,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("datePaiement").descending());
        return paiementService.listerPaiements(detteId, telephone, pageable);
    }
}
