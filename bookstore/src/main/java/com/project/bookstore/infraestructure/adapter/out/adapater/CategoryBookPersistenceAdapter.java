package com.project.bookstore.infraestructure.adapter.out.adapater;

import com.project.bookstore.application.port.out.CategoryBookRepositoryPort;
import com.project.bookstore.domain.model.CategoryBook;
import com.project.bookstore.infraestructure.adapter.out.repository.CategoryBookJpaRepository;
import com.project.bookstore.infraestructure.adapter.out.mappers.CategoryBookPersistanceMapper;
import com.project.bookstore.infraestructure.entities.CategoryBookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryBookPersistenceAdapter implements CategoryBookRepositoryPort {

    private final CategoryBookJpaRepository categoryJpaRepository;

    public CategoryBookPersistenceAdapter(CategoryBookJpaRepository categoryJpaRepository){
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public CategoryBook save(CategoryBook category) {
        CategoryBookEntity entitySaved = categoryJpaRepository.save(CategoryBookPersistanceMapper.toCategoryBookEntity(category));
        return CategoryBookPersistanceMapper.toCategoryBook(entitySaved);
    }

    @Override
    public List<CategoryBook> findAllCategories() {
        return categoryJpaRepository.findAll()
                                    .stream()
                                    .map(entity -> CategoryBookPersistanceMapper.toCategoryBook(entity))
                                    .toList();
    }

    @Override
    public Optional<CategoryBook> findById(Long id) {
        return categoryJpaRepository.findById(id).map(CategoryBookPersistanceMapper::toCategoryBook);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryJpaRepository.deleteById(id);
    }
}
