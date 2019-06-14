package de.liviawelschinger.eshop.restcontrollers;

import de.liviawelschinger.eshop.entities.Product;
import de.liviawelschinger.eshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    // http://localhost:8085/api/rest/product/id
    @RequestMapping(value = "/product/{id}", produces = "application/json", method = RequestMethod.GET)
    public Mono<Product> findById(@PathVariable(name = "id") String id) {
        return productRepository.findById(id);
    }
}
