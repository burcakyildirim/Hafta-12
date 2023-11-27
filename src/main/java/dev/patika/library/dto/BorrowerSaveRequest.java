package dev.patika.library.dto;

import dev.patika.library.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerSaveRequest {
    private String name;
    private LocalDate onDate;
    private LocalDate date;
    private int book_id;
}
