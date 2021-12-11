package com.gainwell.si.repository;

import com.gainwell.si.domain.SIRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SIRequestsRepository extends JpaRepository<SIRequests, String> {


}
