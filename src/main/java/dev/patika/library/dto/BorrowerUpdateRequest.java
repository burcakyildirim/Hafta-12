package dev.patika.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowerUpdateRequest {
    private int id;
    private String name;
    private LocalDate onDate;
    private LocalDate date;
}
