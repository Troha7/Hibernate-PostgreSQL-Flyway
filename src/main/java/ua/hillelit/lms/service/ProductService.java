package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.ProductDto;
import ua.hillelit.lms.model.Product;
import ua.hillelit.lms.repository.ProductRepository;

/**
 * {@link ProductService}
 *
 * @author Dmytro Trotsenko on 1/25/23
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    /**
     * Create new entity {@link Product} and save row with data in database
     *
     * @param productDto object with data
     * @return productDto
     */
    public ProductDto createProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
        log.info("Product id:{} was creating", productDto.getId());
        return productDto;
    }

}
