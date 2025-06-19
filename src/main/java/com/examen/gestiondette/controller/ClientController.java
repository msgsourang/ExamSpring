package com.examen.gestiondette.controller;

import com.examen.gestiondette.model.Client;
import com.examen.gestiondette.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

   
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClientParId(id);
    }

    @GetMapping
    public java.util.List<Client> listerClients() {
        return clientService.listerClients();
    }

  
    @PostMapping
    public ResponseEntity<Client> ajouterClient(@Valid @RequestBody Client client) {
        Client saved = clientService.ajouterClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
