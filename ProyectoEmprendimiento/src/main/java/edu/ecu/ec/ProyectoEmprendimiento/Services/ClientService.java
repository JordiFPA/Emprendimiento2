package edu.ecu.ec.ProyectoEmprendimiento.Services;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Client;
import edu.ecu.ec.ProyectoEmprendimiento.Repositorios.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public void save(Client c){
       clientRepository.save(c);
    }
    public Client findByPlaca(String placa) {
        return clientRepository.findByPlaca(placa);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(String placa, Client updatedClient) {
        Client existingClient = clientRepository.findByPlaca(placa);
        if (existingClient != null) {
            existingClient.setName_client(updatedClient.getName_client());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPhone(updatedClient.getPhone());
            existingClient.setDir(updatedClient.getDir());
            return clientRepository.save(existingClient);
        } else {
            return null;
        }
    }

    public boolean deleteClientByPlaca(String placa) {
        Client client = clientRepository.findByPlaca(placa);
        if (client != null) {
            clientRepository.delete(client);
            return true;
        }
        return false;
    }



}
