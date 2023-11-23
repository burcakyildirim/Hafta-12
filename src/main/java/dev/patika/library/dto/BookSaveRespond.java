package dev.patika.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRespond {
    private int id;
    private String name;
    private int publicationYear;
    private int stock;
}
