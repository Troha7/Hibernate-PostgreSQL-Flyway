package ua.hillelit.lms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.hillelit.lms.dto.*;
import ua.hillelit.lms.service.ClientService;
import ua.hillelit.lms.service.OrderService;
import ua.hillelit.lms.service.ProductService;

import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class MyStoreApp {

    private final ProductService productService;
    private final ClientService clientService;
    private final OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(MyStoreApp.class, args);
    }

    /**
     * Run application after all initialization steps.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        var milk = new ProductDto(1, "Milk", "Cow's milk", 40.75);
        var bread = new ProductDto(2, "Bread", "Black bread", 18.50);
        var cola = new ProductDto(3, "Coca-Cola", "Without sugar", 50.0);
        var sugar = new ProductDto(4, "Sugar", "Brown sugar", 35.60);
        productService.createProduct(milk);
        productService.createProduct(bread);
        productService.createProduct(cola);
        productService.createProduct(sugar);

        var alexClient = new ClientDto(1, "Alex", "alex@gmail.com", "+380999293010");
        ClientDto client = clientService.createClient(alexClient);

        var clientAddress = new AddressDto(1, "Ukraine", "Kharkiv", "Korolenko", "4");
        clientService.addAddress(client, clientAddress);
        clientService.updateAddress(client.getId(), "Ukraine", "Kharkiv", "Korolenko", "19");


        OrderDto order1 = orderService.addOrder(client);
        orderService.addProductToOrder(order1, milk, 2);
        orderService.addProductToOrder(order1, cola, 3);

        OrderDto order2 = orderService.addOrder(client);
        orderService.addProductToOrder(order2, bread, 4);
        orderService.addProductToOrder(order2, sugar, 1);


        List<ClientFullDto> fullClientInfoById = clientService.findFullClientInfoById(1);
        log.info("All info about client: {}", fullClientInfoById);

        List<ClientInfoDto> clientInfoById = clientService.findClientInfoById(1);
        log.info("Info about client: {}", clientInfoById);

        List<ClientAndOrderInfoDto> clientAndOrderInfoById = clientService.findClientAndOrderInfoById(1);
        log.info("Info about client and order: {}", clientAndOrderInfoById);
    }

}
