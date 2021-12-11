package com.gainwell.si.repository;

import com.gainwell.si.domain.SiTransErr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiTransErrRepository extends JpaRepository<SiTransErr, String> {
}
