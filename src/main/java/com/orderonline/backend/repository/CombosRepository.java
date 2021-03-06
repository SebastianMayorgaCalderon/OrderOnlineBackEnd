package com.orderonline.backend.repository;

import com.orderonline.backend.domain.Combos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Combos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CombosRepository extends JpaRepository<Combos, Long> {

    @Query(value = "select distinct combos from Combos combos left join fetch combos.offers",
        countQuery = "select count(distinct combos) from Combos combos")
    Page<Combos> findAllWithEagerRelationships(Pageable pageable);

    @Query(value = "select distinct combos from Combos combos left join fetch combos.offers")
    List<Combos> findAllWithEagerRelationships();

    @Query("select combos from Combos combos left join fetch combos.offers where combos.id =:id")
    Optional<Combos> findOneWithEagerRelationships(@Param("id") Long id);

}
