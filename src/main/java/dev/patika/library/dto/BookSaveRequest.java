package dev.patika.library.dto;

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
}
