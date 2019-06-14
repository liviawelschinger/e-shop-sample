package de.liviawelschinger.eshop;

import de.liviawelschinger.eshop.entities.Category;
import de.liviawelschinger.eshop.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;


@Component // Adds this class to Spring Context
public class MongoDBInitializer {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Bean
    CommandLineRunner init(MongoOperations operations) {
        return args -> {

            //First drop collections
            operations.dropCollection(Category.class);
            operations.dropCollection(Product.class);

            // Create sample data

            Category laptops = new Category(getId("laptops"), "laptops");
            Category mouses = new Category(getId("mouses"), "mouses");
            Category tablets = new Category(getId("tablets"), "tablets");

            operations.insert(laptops);
            operations.insert(mouses);
            operations.insert(tablets);


            //Log sample data

            operations.findAll(Category.class).forEach(category -> {
                log.info("Added category: " + category.getName());
            });

            Product macBookPro = new Product(getId("macBookPro"), "laptops", "MacBook Pro 13 inch i5 8 GB RAM 256 GB SSD", 1999.00);
            Product magicMouse = new Product(getId("magicMouse"), "mouses", "Apple Magic Mouse 2", 79.00);
            Product ipadPro11 = new Product(getId("ipadPro11"), "tablets", "iPad Pro 11 inch Cellular + WiFi 256 GB Flash", 899.00);

            operations.insert(macBookPro);
            operations.insert(magicMouse);
            operations.insert(ipadPro11);

            operations.findAll(Product.class).forEach(product -> {
                log.info("Added product: " + product);
            });
        };

    }

    // Generate an unique ID for a category or a product
    private String getId(String identifier){
        return Long.valueOf(System.currentTimeMillis()).toString() + "_" + identifier;
    }

}
