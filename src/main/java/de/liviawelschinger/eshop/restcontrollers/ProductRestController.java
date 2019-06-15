package de.liviawelschinger.eshop.restcontrollers;

import de.liviawelschinger.eshop.entities.Category;
import de.liviawelschinger.eshop.entities.Product;
import de.liviawelschinger.eshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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


    // curl -X DELETE http://localhost:8085/api/rest/deleteProduct/id
    @RequestMapping(value = "/deleteProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public Mono<Void> deleteById(@PathVariable(name = "id") String id) {
       return productRepository.deleteById(id);
    }

    //  curl -X POST -H "Content-Type: application/json" -d '{"name": "keyboards"}'  http://localhost:8085/api/rest/saveCategory
    //  returns: {"id":"5d049be0c77b6d820faf6dff","name":"keyboards"}
    @RequestMapping(value = "/saveProduct", consumes = "application/json" , produces = "application/json", method = RequestMethod.POST)
    public Mono<Product> saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
