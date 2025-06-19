package com.examen.gestiondette.service;

import com.examen.gestiondette.model.Client;
import com.examen.gestiondette.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientParId(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable avec id: " + id));
    }

    public Client getClientParTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable avec téléphone: " + telephone));
    }

    public java.util.List<Client> listerClients() {
        return clientRepository.findAll();
    }
}
