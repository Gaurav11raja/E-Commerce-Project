package com.reza.ecommerse.repo.account;

import com.reza.ecommerse.model.account.AccountBio;
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
public interface AccountBioRepository extends CrudRepository<AccountBio, Long> {
    @Modifying
    @Query(value = "UPDATE AccountBio SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE AccountBio SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false")
    void softDeleteAll();

    @Modifying
    @Query(value = "UPDATE AccountBio SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true AND id = :id")
    void restoreDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE AccountBio SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true")
    void restoreDeleteAll();

    /**
     * query to return single or multiple data in pagination form of AccountBio
     * @param sSearch keyword for data search
     * @param pageable PageRequest for data search
     * @return Page object of AccountBio
     */
    @Query(value = "SELECT a FROM AccountBio a WHERE a.deleted = false and " +
            "(LOWER(a.id) LIKE %:sSearch% OR LOWER(a.address) LIKE %:sSearch% OR LOWER(a.fullName) LIKE %:sSearch% " +
            "OR LOWER(a.phoneNumber) LIKE %:sSearch%)")
    Page<AccountBio> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
