package de.liviawelschinger.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // for Lombok (no need to generate Getters, Setters and Constructors)
@Document(collection = "products") // for MongoDB as a NoSQL, document based data store
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String category;
    private String name;
    private Double price;
}
