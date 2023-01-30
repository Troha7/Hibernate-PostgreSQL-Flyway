package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.ClientDto;
import ua.hillelit.lms.dto.OrderDto;
import ua.hillelit.lms.dto.OrderItemDto;
import ua.hillelit.lms.dto.ProductDto;
import ua.hillelit.lms.model.Client;
import ua.hillelit.lms.model.Order;
import ua.hillelit.lms.model.OrderItem;
import ua.hillelit.lms.model.Product;
import ua.hillelit.lms.repository.OrderItemRepository;
import ua.hillelit.lms.repository.OrderRepository;

/**
 * {@link OrderService}
 *
 * @author Dmytro Trotsenko on 1/28/23
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ObjectMapper objectMapper;

    /**
     * Add new Order to the database
     *
     * @param clientDto client
     * @return OrderDto
     */
    public OrderDto addOrder(ClientDto clientDto) {
        var orderModel = new Order();
        Client client = objectMapper.convertValue(clientDto, Client.class);
        orderModel.setClient(client);
        orderRepository.save(orderModel);
        log.info("Client id:{} add new Order", clientDto.getId());
        return objectMapper.convertValue(orderModel, OrderDto.class);
    }

    /**
     * Add product to the order and save in database
     *
     * @param orderDto   order
     * @param productDto product
     * @param count      quantity
     * @return OrderItemDto
     */
    public OrderItemDto addProductToOrder(OrderDto orderDto, ProductDto productDto, Integer count) {

        var orderItemModel = new OrderItem();
        orderItemModel.setCount(count);

        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderItemModel.setOrder(order);

        Product product = objectMapper.convertValue(productDto, Product.class);
        orderItemModel.setProduct(product);

        orderItemRepository.save(orderItemModel);
        log.info("Client add {} products id:{} to order id:{}", count, productDto.getId(), orderDto.getId());
        return objectMapper.convertValue(orderItemModel, OrderItemDto.class);
    }

}
