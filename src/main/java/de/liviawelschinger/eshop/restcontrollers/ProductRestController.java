package de.liviawelschinger.eshop.restcontrollers;

import de.liviawelschinger.eshop.entities.Product;
import de.liviawelschinger.eshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/rest")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    // http://localhost:8085/api/rest/products
    @RequestMapping(value = "/products", produces = "application/json", method = RequestMethod.GET)
    public Flux<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
