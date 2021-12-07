package com.gainwell.si.domain;

import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Component
@Entity
@Table(schema = "public", name = "si_request")
public class SIRequests implements Persistable<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "seqGen", strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "seqGen", sequenceName = "si_requests_uniqueidentifier_seq", allocationSize = 1)
    @Id
    @Column(name = "REQ_ID", columnDefinition = "serial")
    private Long id;

    @Column(name = "MOD_TRNS_ID")
    private String moduleTxnID;

    @Column(name = "SI_TRNS_ID")
    private String siTxnKey;

    @Column(name = "BUSS_FLOW")
    private String businessFlow;

    @Column(name = "method")
    private String method;

    @Column(name = "REQ_SYS")
    private String requestorSystem;

    @Column(name = "ST_CD")
    private String uniqueStateCode;

    @Column(name = "REQ_DTTM")
    private LocalDateTime requestTimestamp;

   /* @Transient
    private boolean isNew = false;

    SIRequests(Long uniqueIdentifier, boolean isNew) {
        this.uniqueIdentifier = uniqueIdentifier;
        this.isNew = isNew;
    }*/

    // prevent Spring Data doing a select-before-insert - this particular entity is never updated
    @Override
    public boolean isNew() {
        return true;
    }

/*    @Override
    public Long getId() {
        return uniqueIdentifier;
    }*/

}