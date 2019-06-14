package de.liviawelschinger.eshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // for Lombok (no need to generate Getters, Setters and Constructors)
@Document(collection = "categories") // for MongoDB as a NoSQL, document based data store
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String id;
    private String name;


}
