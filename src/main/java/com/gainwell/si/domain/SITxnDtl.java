package com.gainwell.si.domain;

import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Component
@Entity
@Table(schema = "public", name = "SI_TRANS_DTL")
public class SITxnDtl {//} implements Persistable<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TRANS_DTL_ID")
    private Long id;
    @Column(name = "SUBR_SYS")
    private String subrSys;
    @Column(name = "SI_TRNS_ID")
    private String siTrnsID;
    @Column(name = "BUSS_FLOW")
    private String bussFlow;
    @Column(name = "REQ_STS")
    private String reqSts;
    @Column(name = "RESP_DTTM")
    private LocalDateTime respDttm;

/*    @Override
    public boolean isNew() {
        return true;
    }*/

}
