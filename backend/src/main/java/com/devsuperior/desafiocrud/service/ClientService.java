package com.devsuperior.desafiocrud.service;

import com.devsuperior.desafiocrud.dto.ClientDTO;
import com.devsuperior.desafiocrud.entity.Client;
import com.devsuperior.desafiocrud.repository.ClientRepository;
import com.devsuperior.desafiocrud.service.exceptions.DataBaseException;
import com.devsuperior.desafiocrud.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> clientPaged = clientRepository.findAll(pageRequest);
        return clientPaged.map(client -> new ClientDTO(client));
    }

    @Transactional
    public ClientDTO findById(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client = optionalClient.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();
        convertClientDtoToEntity(clientDTO, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    private void convertClientDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client;
        try {
            client = clientRepository.getReferenceById(id);
            convertClientDtoToEntity(clientDTO, client);
            client = clientRepository.save(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }

        return new ClientDTO(client);
    }

    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataBaseException("Integrity violation");
        }
    }
}
