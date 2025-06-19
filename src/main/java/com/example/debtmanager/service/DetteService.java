package com.examen.gestiondette.service;

import com.examen.gestiondette.model.Client;
import com.examen.gestiondette.model.Dette;
import com.examen.gestiondette.repository.DetteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetteService {

    private final DetteRepository detteRepository;
    private final ClientService clientService;

    public Dette ajouterDette(Long clientId, Dette dette) {
        Client client = clientService.getClientParId(clientId);
        dette.setClient(client);
        return detteRepository.save(dette);
    }

    public Page<Dette> listerDettesParTelephone(String telephone, Pageable pageable) {
        return detteRepository.findByClientTelephone(telephone, pageable);
    }

    public Page<Dette> listerDettesParClient(Long clientId, Pageable pageable) {
        Client client = clientService.getClientParId(clientId);
        return detteRepository.findByClientTelephone(client.getTelephone(), pageable);
    }

    public Dette getDette(Long id) {
        return detteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dette introuvable avec id: " + id));
    }
}
