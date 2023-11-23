package dev.patika.library.business.concretes;

import dev.patika.library.business.abstracts.IBorrowingService;
import dev.patika.library.dao.BorrowingRepo;
import dev.patika.library.entities.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingManager implements IBorrowingService {

    @Autowired
    private BorrowingRepo borrowingRepo;

    @Override
    public Borrowing getById(int id) {
        return this.borrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public Borrowing save(Borrowing borrowing) {
        return this.borrowingRepo.save(borrowing);
    }

    @Override
    public Borrowing update(Borrowing borrowing) {
        return this.borrowingRepo.save(borrowing);
    }

    @Override
    public void delete(int id) {
        this.borrowingRepo.delete(this.getById(id));
    }

    @Override
    public List<Borrowing> findAll() {
        return this.borrowingRepo.findAll();
    }
}
