package com.orderonline.backend.service;

import com.orderonline.backend.domain.*;
import com.orderonline.backend.repository.CategoryRepository;
import com.orderonline.backend.service.dto.CategoryDTO;
import com.orderonline.backend.service.mapper.CategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Category.
 */
@Service
@Transactional
public class CategoryService {

    private final Logger log = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    private final RestaurantService restaurantService;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, RestaurantService restaurantService) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.restaurantService = restaurantService;
    }

    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save
     * @return the persisted entity
     */
    public CategoryDTO save(CategoryDTO categoryDTO) {
        log.debug("Request to save Category : {}", categoryDTO);

        Category category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    /**
     * Get all the categories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable, String restaurantAdminEmail) {
        log.debug("Request to get all Categories");
        Restaurant restaurant = this.restaurantService.findOneByRestaurantAdminEmail(restaurantAdminEmail);
        return categoryRepository.findAllByRestaurant(pageable,restaurant)
            .map(categoryMapper::toDto);
    }

    /**
     * Get one category by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<CategoryDTO> findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findById(id)
            .map(categoryMapper::toDto);
    }

    /**
     * Delete the category by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.deleteById(id);
    }
}
