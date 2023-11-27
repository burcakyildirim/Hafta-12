package dev.patika.library.api;

import dev.patika.library.business.abstracts.IBorrowingService;
import dev.patika.library.dto.BorrowerSaveRequest;
import dev.patika.library.dto.BorrowerUpdateRequest;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.Borrowing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BorrowingController {

    @Autowired
    private final IBorrowingService borrowingService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BorrowingController(IBorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/borrowings")
    @ResponseStatus(HttpStatus.OK)
    public List<Borrowing> findAll() {
        return this.borrowingService.findAll();
    }

    @PostMapping("/borrowings")
    @ResponseStatus(HttpStatus.CREATED)
    public Borrowing save(@RequestBody BorrowerSaveRequest borrowerSaveRequest) {
        Borrowing newBorrow = this.modelMapper.map(borrowerSaveRequest,Borrowing.class);
        Book book = new Book();
        book.setId((long) borrowerSaveRequest.getBook_id());
        newBorrow.setBook(book);
        return this.borrowingService.save(newBorrow);
    }

    @PutMapping("/borrowings")
    @ResponseStatus(HttpStatus.OK)
    public Borrowing update(@RequestBody BorrowerUpdateRequest borrowerUpdateRequest) {
        Borrowing updatedBorrower = this.borrowingService.getById(borrowerUpdateRequest.getId());
        updatedBorrower.setName(borrowerUpdateRequest.getName());
        updatedBorrower.setOnDate(borrowerUpdateRequest.getOnDate());
        updatedBorrower.setDate(borrowerUpdateRequest.getDate());
        return this.borrowingService.update(updatedBorrower);
    }

    @DeleteMapping("/borrowings/{id}")
    public void delete(@PathVariable("id") int id) {
        this.borrowingService.delete(id);
    }

    @GetMapping("/borrowings/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Borrowing getById(@PathVariable("id") int id) {
        return this.borrowingService.getById(id);
    }
}
