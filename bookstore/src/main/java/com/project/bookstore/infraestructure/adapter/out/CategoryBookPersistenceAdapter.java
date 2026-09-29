package com.project.bookstore.infraestructure.adapter.out;

import com.project.bookstore.application.port.out.CategoryBookRepositoryPort;
import com.project.bookstore.domain.model.CategoryBook;
import com.project.bookstore.infraestructure.entities.CategoryBookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryBookPersistenceAdapter implements CategoryBookRepositoryPort {

    private final CategoryBookJpaRepository categoryJpaRepository;

    public CategoryBookPersistenceAdapter(CategoryBookJpaRepository categoryJpaRepository){
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public CategoryBook save(CategoryBook category) {
        CategoryBookEntity entitySaved = categoryJpaRepository.save(CategorybookPersistanceMapper.toCategoryBookEntity(category));
        return CategorybookPersistanceMapper.toCategoryBook(entitySaved);
    }

    @Override
    public List<CategoryBook> findAllCategories() {
        return categoryJpaRepository.findAll()
                                    .stream()
                                    .map(entity -> CategorybookPersistanceMapper.toCategoryBook(entity))
                                    .toList();
    }
}
