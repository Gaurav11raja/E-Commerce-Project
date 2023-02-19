package com.reza.ecommerse.repo.master;

import com.reza.ecommerse.model.master.Role;
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
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Modifying
    @Query(value = "UPDATE Role SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE Role SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false")
    void softDeleteAll();

    @Modifying
    @Query(value = "UPDATE Role SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true AND id = :id")
    void restoreDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE Role SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true")
    void restoreDeleteAll();

    /**
     * query to return single or multiple data in pagination form of Role
     * @param sSearch keyword for data search
     * @param pageable PageRequest for data search
     * @return Page object of Role
     */
    @Query(value = "SELECT a FROM Role a WHERE a.deleted = false AND " +
            "(LOWER(a.name) LIKE %:sSearch% OR LOWER(a.code) LIKE %:sSearch% OR " +
            "LOWER(a.id) LIKE %:sSearch%)")
    Page<Role> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
