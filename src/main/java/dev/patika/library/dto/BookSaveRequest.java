package dev.patika.library.dto;

import dev.patika.library.entities.Author;
import dev.patika.library.entities.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSaveRequest {
    private String name;
    private int publicationYear;
    private int stock;
    private Author author;
    private Publisher publisher;
}
