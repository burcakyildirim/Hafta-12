package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Borrowing;

import java.util.List;

public interface IBorrowingService {

    Borrowing getById(int id);
    Borrowing save(Borrowing borrowing);
    Borrowing update(Borrowing borrowing);
    void delete (int id);
    List<Borrowing> findAll();
}
