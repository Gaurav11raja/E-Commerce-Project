package com.reza.ecommerse.repo.account;

import com.reza.ecommerse.model.account.AccountInfo;
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
public interface AccountInfoRepository extends CrudRepository<AccountInfo, Long> {
    @Modifying
    @Query(value = "UPDATE AccountInfo SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false AND id = :id")
    void softDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE AccountInfo SET deleted = true, updatedBy = 'system' " +
            "WHERE deleted = false")
    void softDeleteAll();

    @Modifying
    @Query(value = "UPDATE AccountInfo SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true AND id = :id")
    void restoreDelete(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE AccountInfo SET deleted = false, updatedBy = 'system' " +
            "WHERE deleted = true")
    void restoreDeleteAll();

    @Query(value = "SELECT a FROM AccountInfo a WHERE a.deleted = false AND (LOWER(a.id) LIKE %:sSearch% OR " +
            "LOWER(a.email) LIKE %:sSearch% OR LOWER(a.role.code) LIKE %:sSearch% OR " +
            "LOWER(a.accountBio.fullName) LIKE %:sSearch%)")
    Page<AccountInfo> getPageable(@Param("sSearch") String sSearch, Pageable pageable);
}
