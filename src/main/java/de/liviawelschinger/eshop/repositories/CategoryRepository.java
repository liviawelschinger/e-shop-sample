package de.liviawelschinger.eshop.repositories;

import de.liviawelschinger.eshop.entities.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{


}
