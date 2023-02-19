package com.reza.ecommerse.repo.file;

import com.reza.ecommerse.model.file.File;
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
public interface FileRepository extends CrudRepository<File, Long> {
    @Modifying
    @Query(value = "UPDATE File SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    /**
     * query to return single or multiple data in pagination form of File
     * @param sSearch keyword for data search by code
     * @param pageable PageRequest for data search
     * @return Page object of File
     */
    @Query(value = "SELECT a FROM File a WHERE a.deleted = false AND " +
            "(LOWER(a.extension) LIKE %:sSearch%)")
    Page<File> findByFileExtension(@Param("sSearch") String sSearch, Pageable pageable);
}
