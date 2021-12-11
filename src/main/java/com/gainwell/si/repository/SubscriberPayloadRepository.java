package com.gainwell.si.repository;

import com.gainwell.si.domain.SubscriberPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberPayloadRepository extends JpaRepository<SubscriberPayload, String> {
}
