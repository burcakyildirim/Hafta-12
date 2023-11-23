package dev.patika.library.api;

import dev.patika.library.business.abstracts.ICategoryService;
import dev.patika.library.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController {
    @Autowired
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController (ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }


    @PutMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category) {
        return this.categoryService.update(category);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable ("id") int id) {
        this.categoryService.delete(id);
    }

    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getById(@PathVariable("id") int id) {
        return this.categoryService.getById(id);
    }
}
