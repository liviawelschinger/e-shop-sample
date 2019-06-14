package de.liviawelschinger.eshop.repositories;

import de.liviawelschinger.eshop.entities.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
