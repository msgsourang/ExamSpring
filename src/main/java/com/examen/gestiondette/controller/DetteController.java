package com.examen.gestiondette.controller;

import com.examen.gestiondette.model.Dette;
import com.examen.gestiondette.service.DetteService;
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
public class DetteController {

    private final DetteService detteService;

  
    @PostMapping("/clients/{clientId}/dettes")
    public ResponseEntity<Dette> ajouterDette(@PathVariable Long clientId, @Valid @RequestBody Dette dette) {
        Dette saved = detteService.ajouterDette(clientId, dette);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/clients/{clientId}/dettes")
    public Page<Dette> listerDettesParClient(@PathVariable Long clientId,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dateCreation").descending());
        return detteService.listerDettesParClient(clientId, pageable);
    }

    @GetMapping("/dettes")
    public Page<Dette> listerDettesParTelephone(@RequestParam String telephone,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dateCreation").descending());
        return detteService.listerDettesParTelephone(telephone, pageable);
    }
}
