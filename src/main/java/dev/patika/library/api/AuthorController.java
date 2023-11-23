package dev.patika.library.api;

import dev.patika.library.business.abstracts.IAuthorService;
import dev.patika.library.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AuthorController {
    @Autowired
    private final IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) {
        return this.authorService.save(author);
    }
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@RequestBody Author author) {
        return this.authorService.update(author);
    }
    @DeleteMapping("/authors/{id}")
    public void delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
    }

    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getById(@PathVariable("id") int id) {
        return this.authorService.getById(id);
    }
}
