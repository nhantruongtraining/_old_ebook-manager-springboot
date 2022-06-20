package com.axonactive.training.ebookapp.api;

import com.axonactive.training.ebookapp.api.request.CategoryRequest;
import com.axonactive.training.ebookapp.entity.Category;
import com.axonactive.training.ebookapp.exception.ResourceNotFoundException;
import com.axonactive.training.ebookapp.service.CategoryService;
import com.axonactive.training.ebookapp.service.dto.CategoryDto;
import com.axonactive.training.ebookapp.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(CategoryResources.PATH)
public class CategoryResources {
    public static final String PATH = "/api/categories";

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<Category> categoryList = categoryService.getAll();
        return ResponseEntity.ok(CategoryMapper.INSTANCE.toDtos(categoryList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) throws ResourceNotFoundException {
        Category category = categoryService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return ResponseEntity.ok().body(CategoryMapper.INSTANCE.toDto(category));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryRequest category) {
        Category createdCategory = categoryService.save(new Category(
                null, category.getValue()));
        return ResponseEntity.created(URI.create(PATH + "/" + createdCategory.getId()))
                .body(CategoryMapper.INSTANCE.toDto(createdCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable(value = "id") Integer id,
                                              @RequestBody CategoryRequest categoryUpdate) throws ResourceNotFoundException {
        Category category = categoryService.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID not found: " + id));
        category.setValue(categoryUpdate.getValue());
        Category editedCategory = categoryService.save(category);
        return ResponseEntity.ok().body(CategoryMapper.INSTANCE.toDto(editedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
