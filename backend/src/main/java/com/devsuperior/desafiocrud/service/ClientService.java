package com.devsuperior.desafiocrud.service;

import com.devsuperior.desafiocrud.dto.ClientDTO;
import com.devsuperior.desafiocrud.entity.Client;
import com.devsuperior.desafiocrud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> clientPaged = clientRepository.findAll(pageRequest);
        return clientPaged.map(client -> new ClientDTO(client));
    }
}
