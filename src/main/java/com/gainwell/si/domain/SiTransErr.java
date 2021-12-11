package com.gainwell.si.domain;

import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Component
@Entity
@Table(schema = "public", name = "SI_TRANS_ERR")
public class SiTransErr implements Persistable<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TRANS_ERR_ID")
    private Long id;
    @Column(name = "SUBR_SYS")
    private String subrSys;
    @Column(name = "SI_TRNS_ID")
    private String siTrnsID;
    @Column(name = "ERR_CD")
    private String errCd;
    @Column(name = "ERR_DTL")
    private String errDtl;
    @Column(name = "ERR_RESP_DTTM")
    private LocalDateTime errRespDttm;

    @Override
    public boolean isNew() {
        return true;
    }
}
