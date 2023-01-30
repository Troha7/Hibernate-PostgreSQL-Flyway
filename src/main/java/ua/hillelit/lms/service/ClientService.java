package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hillelit.lms.dto.*;
import ua.hillelit.lms.model.Address;
import ua.hillelit.lms.model.Client;
import ua.hillelit.lms.repository.AddressRepository;
import ua.hillelit.lms.repository.ClientRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * {@link ClientService}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ObjectMapper objectMapper;

    /**
     * Create new entity {@link Client} and save row with data in database
     *
     * @param clientDto object with data
     * @return clientDto
     */
    public ClientDto createClient(ClientDto clientDto) {
        Client client = objectMapper.convertValue(clientDto, Client.class);
        clientRepository.save(client);
        clientDto.setId(client.getId());
        log.info("Client id:{} was creating", clientDto.getId());
        return clientDto;
    }

    /**
     * Add Client address to the database
     *
     * @param clientDto client
     * @param addressDto address
     * @return new address
     */
    public AddressDto addAddress(ClientDto clientDto, AddressDto addressDto) {
        Address address = objectMapper.convertValue(addressDto, Address.class);
        Client client = objectMapper.convertValue(clientDto, Client.class);
        client.setAddress(address);
        clientRepository.save(client);
        log.info("Client id:{} add Address", clientDto.getId());
        return addressDto;
    }

    /**
     * Update Client address in the database
     *
     * @param clientId client id
     * @param country country
     * @param city city
     * @param street street
     * @param house house
     * @return new address
     */
    public AddressDto updateAddress(Integer clientId, String country, String city, String street, String house) {
        Client client = clientRepository
                .findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client with id=" + clientId + "wasn't found"));

        var addressModel = new Address();
        addressModel.setCountry(country);
        addressModel.setCity(city);
        addressModel.setStreet(street);
        addressModel.setHouse(house);
        addressModel.setId(client.getId());
        addressModel.setClient(client);

        addressRepository.save(addressModel);
        log.info("Address for client id:{} was updated", client.getId());
        return objectMapper.convertValue(addressModel, AddressDto.class);
    }

    /**
     * Find full information about client by client id
     *
     * @param clientId client id
     * @return full information about client
     */
    @Transactional(readOnly = true)
    public List<ClientFullDto> findFullClientInfoById(Integer clientId) {
        var clients = clientRepository.findClientById(clientId);
        return clients.stream()
                .map(c -> objectMapper.convertValue(c, ClientFullDto.class))
                .collect(toList());
    }

    /**
     * Find only information about client and address by client id
     *
     * @param clientId client id
     * @return only information about client and address
     */
    @Transactional(readOnly = true)
    public List<ClientInfoDto> findClientInfoById(Integer clientId) {
        var clients = clientRepository.findClientById(clientId);
        return clients.stream()
                .map(c -> objectMapper.convertValue(c, ClientInfoDto.class))
                .collect(toList());
    }

    /**
     * Find only information about client, address and orders by client id
     *
     * @param clientId client id
     * @return only information about client, address and orders
     */
    @Transactional(readOnly = true)
    public List<ClientAndOrderInfoDto> findClientAndOrderInfoById(Integer clientId) {
        var clients = clientRepository.findClientById(clientId);
        return clients.stream()
                .map(c -> objectMapper.convertValue(c, ClientAndOrderInfoDto.class))
                .collect(toList());
    }

}
