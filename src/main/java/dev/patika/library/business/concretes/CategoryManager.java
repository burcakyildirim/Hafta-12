package dev.patika.library.business.concretes;

import dev.patika.library.business.abstracts.ICategoryService;
import dev.patika.library.dao.CategoryRepo;
import dev.patika.library.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category getById(int id) {
        return this.categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepo.delete(this.getById(id));
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
