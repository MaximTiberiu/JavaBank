package javabank.service;

import javabank.domain.Client;
import javabank.domain.validators.ValidationException;
import javabank.repository.memory.InMemoryRepository;
import javabank.service.validators.ClientValidatorService;
import javabank.service.validators.ValidatorService;

import java.text.ParseException;

public class ClientService {
    private final InMemoryRepository<Long, Client> clientInMemoryRepository;
    private final ValidatorService<Client> clientValidatorService = new ClientValidatorService();

    /**
     * Constructor that creates a new BankService
     * @param clientInMemoryRepository InMemoryRepository<Long, Client>, representing the Repository that handles the Client data
     */
    public ClientService(InMemoryRepository<Long, Client> clientInMemoryRepository) {
        this.clientInMemoryRepository = clientInMemoryRepository;
    }

    /**
     * Method that adds a new Client
     * @param clientParam Client, representing the Client to be added
     * @return  null,            if the given Client is saved
     *          non-null Client, otherwise (eg. Client with the same id already exists)
     * @throws ValidationException, if the Client to be added already exists
     * @throws ParseException, an exception
     */
    public Client addClient(Client clientParam) throws ValidationException, ParseException {
        Client client = clientInMemoryRepository.save(clientParam);
        clientValidatorService.validateAdd(client);
        return client;
    }

    /**
     * Method that deletes a Bank
     * @param clientIDParam, representing the ID of the Client to be deleted
     * @return  null,               if the Client to be deleted doesn't exist
     *          non-null Client,    otherwise: representing the Client that was deleted
     * @throws ValidationException, if the Client to be deleted doesn't exist
     */
    public Client deleteClient(Long clientIDParam) throws ValidationException {
        Client client = clientInMemoryRepository.delete(clientIDParam);
        clientValidatorService.validateDelete(client);
        return client;
    }
}
