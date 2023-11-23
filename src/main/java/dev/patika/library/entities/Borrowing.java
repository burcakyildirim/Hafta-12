package dev.patika.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "borrowings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrower_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "borrower_name", nullable = false)
    @NotNull
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "borrowing_on_date", nullable = false)
    private LocalDate onDate;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "borrowReturn_date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
