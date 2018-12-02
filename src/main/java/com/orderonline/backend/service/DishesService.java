package com.orderonline.backend.service;

import com.orderonline.backend.domain.*;
import com.orderonline.backend.repository.DishesRepository;
import com.orderonline.backend.service.dto.DishesDTO;
import com.orderonline.backend.service.mapper.DishesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Dishes.
 */
@Service
@Transactional
public class DishesService {

    private final Logger log = LoggerFactory.getLogger(DishesService.class);

    private final DishesRepository dishesRepository;

    private final DishesMapper dishesMapper;

    private final CategoryService categoryService;

    public DishesService(DishesRepository dishesRepository, DishesMapper dishesMapper, CategoryService categoryService) {
        this.dishesRepository = dishesRepository;
        this.dishesMapper = dishesMapper;
        this.categoryService = categoryService;
    }

    /**
     * Save a dishes.
     *
     * @param dishesDTO the entity to save
     * @return the persisted entity
     */
    public DishesDTO save(DishesDTO dishesDTO) {
        log.debug("Request to save Dishes : {}", dishesDTO);

        Dishes dishes = dishesMapper.toEntity(dishesDTO);
        dishes = dishesRepository.save(dishes);
        return dishesMapper.toDto(dishes);
    }

    /**
     * Get all the dishes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<DishesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Dishes");
        return dishesRepository.findAll(pageable)
            .map(dishesMapper::toDto);
    }


    public Page<DishesDTO> findAllByCategory(Pageable pageable, String categoryId) {
        long id = Long.parseLong(categoryId);
        log.debug("Request to get all Dishes");
        Category category = this.categoryService.toEntity(categoryService.findOne(id).orElse(null));
        return dishesRepository.findAllByAvailableAndCategory(pageable, true, category)
            .map(dishesMapper::toDto);
    }
    /**
     * Get all the Dishes with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<DishesDTO> findAllWithEagerRelationships(Pageable pageable) {
        return dishesRepository.findAllWithEagerRelationships(pageable).map(dishesMapper::toDto);
    }


    /**
     * Get one dishes by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<DishesDTO> findOne(Long id) {
        log.debug("Request to get Dishes : {}", id);
        return dishesRepository.findOneWithEagerRelationships(id)
            .map(dishesMapper::toDto);
    }

    /**
     * Delete the dishes by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Dishes : {}", id);
        dishesRepository.deleteById(id);
    }
}
