package com.gainwell.si.domain;

import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Component
@Entity
@Table(schema = "public", name = "subscriberpayload")
public class SubscriberPayload implements Persistable<Long> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "subr_sys")
    private String subrSys;
    @Column(name = "payload")
    private String payload;
    @Column(name = "resp_dttm")
    private LocalDateTime respDttm;

    @Override
    public boolean isNew() {
        return true;
    }
}
