package com.example.Banking3.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping()
    public List<Client> getUsers(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.
                findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw  new IllegalStateException("email taken");
        }
        clientRepository.save(client);
    }


    public void deleteClient(Long clientId) {
        boolean exist = clientRepository.existsById(clientId);
        if(!exist) {
            throw new IllegalStateException(
                    "client with id " + clientId + " does;t exist");
        }
        clientRepository.deleteById(clientId);

    }

    @Transactional
    public void updateStudent(Long clientId, String name, String email) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalStateException("client with id " + clientId + " do not exist"));

        if (name != null && name.length() > 0 && !client.getName().equals(name)) {
            client.setName(name);

        }

        if (email != null && email.length() > 0 && !client.getEmail().equals(email)) {
           Optional<Client> optionalClient = clientRepository.findClientByEmail(email);
           if (optionalClient.isPresent()){
               throw new IllegalStateException("email taken !!");
           }
            client.setEmail(email);
        }
    }
}
