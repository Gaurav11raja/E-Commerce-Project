package com.reza.ecommerse.repo.transaction;

import com.reza.ecommerse.model.transaction.TransactionItem;
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
public interface TransactionItemRepository extends CrudRepository<TransactionItem, Long> {
    @Modifying
    @Query(value = "UPDATE TransactionItem SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE TransactionItem SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false")
    void softDeleteAll();

    @Modifying
    @Query(value = "UPDATE TransactionItem SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true AND id = :id")
    void restoreDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE TransactionItem SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true")
    void restoreDeleteAll();

    /**
     * query to return single or multiple data in pagination form of TransactionItem
     * @param sSearch keyword for data search
     * @param pageable PageRequest for data search
     * @return Page object of TransactionItem
     */
    @Query(value = "SELECT a FROM TransactionItem a WHERE a.deleted = false AND " +
            "(LOWER(a.id) LIKE %:sSearch% OR LOWER(a.item.name) LIKE %:sSearch%)")
    Page<TransactionItem> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
