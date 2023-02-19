package com.reza.ecommerse.repo.master;

import com.reza.ecommerse.model.master.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Modifying
    @Query(value = "UPDATE Item SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE Item SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false")
    void softDeleteAll();

    @Modifying
    @Query(value = "UPDATE Item SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true AND id = :id")
    void restoreDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE Item SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true")
    void restoreDeleteAll();

    /**
     * query to return single or multiple data in pagination form of Item
     * @param sSearch keyword for data search
     * @param pageable PageRequest for data search
     * @return Page object of Item
     */
    @Query(value = "SELECT a FROM Item a WHERE a.deleted = false AND " +
            "(LOWER(a.id) LIKE %:sSearch% OR LOWER(a.name) LIKE %:sSearch% OR " +
            "LOWER(a.category.name) LIKE %:sSearch% OR LOWER(a.description) LIKE %:sSearch% OR " +
            "LOWER(a.price) LIKE %:sSearch% OR LOWER(a.reputation) LIKE %:sSearch%)")
    Page<Item> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
