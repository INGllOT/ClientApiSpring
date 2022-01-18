package com.example.Banking3.Client;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {


    private final ClientService clientService;




    @GetMapping()
    public List<Client> getUsers(){
        return clientService.getUsers();
    }

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "/{clientId}")
    public void deleteCient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email) {

        clientService.updateStudent(clientId, name, email);
    }
}
