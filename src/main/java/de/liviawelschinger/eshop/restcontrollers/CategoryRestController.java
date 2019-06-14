package de.liviawelschinger.eshop.restcontrollers;

import de.liviawelschinger.eshop.entities.Category;
import de.liviawelschinger.eshop.entities.Product;
import de.liviawelschinger.eshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/rest")
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    // http://localhost:8085/api/rest/categories
    @RequestMapping(value = "/categories", produces = "application/json", method = RequestMethod.GET)
    public Flux<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    // http://localhost:8085/api/rest/category/id
    @RequestMapping(value = "/category/{id}", produces = "application/json", method = RequestMethod.GET)
    public Mono<Category> findById(@PathVariable(name = "id") String id) {
        return  categoryRepository.findById(id);
    }

    // curl -X DELETE http://localhost:8085/api/rest/deleteCategory/id
    @RequestMapping(value = "/deleteCategory/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public Mono<Void> deleteById(@PathVariable(name = "id") String id) {
        return categoryRepository.deleteById(id);
    }


}
