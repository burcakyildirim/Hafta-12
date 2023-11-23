package dev.patika.library.dto;

import dev.patika.library.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherGetRequest {
    private int id;
    private String name;
    private int establishmentYear;
}
