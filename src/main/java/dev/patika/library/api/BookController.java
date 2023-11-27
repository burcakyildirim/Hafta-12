package dev.patika.library.api;

import dev.patika.library.business.abstracts.IBookService;
import dev.patika.library.dto.BookSaveRequest;
import dev.patika.library.dto.BookSaveRespond;
import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    private final IBookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookSaveRespond> findAll() {
        List<BookSaveRespond> bookSaveRespondList = this.bookService.findAll().stream().map(
                book -> this.modelMapper.map(book,BookSaveRespond.class)
        ).collect(Collectors.toList());
        return bookSaveRespondList;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody BookSaveRequest bookSaveRequest) {
        Book newBook = this.modelMapper.map(bookSaveRequest,Book.class);

        /*Author author = new Author();
        author.setId((long) bookSaveRequest.getAuthor_id());
        newBook.setAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setId((long) bookSaveRequest.getPublisher_id());
        newBook.setPublisher(publisher);

         */
        return this.bookService.save(newBook);
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book) {
        return this.bookService.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") int id) {
        return this.bookService.getById(id);
    }
}
