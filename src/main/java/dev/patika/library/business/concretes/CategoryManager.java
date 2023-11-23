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
    public boolean delete(int id) {
        Category category = categoryRepo.findById(id).get();
        if(category.getBookList().isEmpty()) {
            categoryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
