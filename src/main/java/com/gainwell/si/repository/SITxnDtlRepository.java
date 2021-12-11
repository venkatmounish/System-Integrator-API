package com.gainwell.si.repository;

import com.gainwell.si.domain.SITxnDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SITxnDtlRepository extends JpaRepository<SITxnDtl, String> {
}
