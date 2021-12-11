package com.gainwell.si.service;


import com.gainwell.si.repository.SITxnDtlRepository;
import com.gainwell.si.domain.SITxnDtl;
import com.gainwell.si.utils.Constants;
import com.gainwell.si.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SITxnDtlService {

    @Autowired
    SITxnDtlRepository siTxnDtlRepository;

    @Autowired
    SITxnDtl siTxnDtl;

    @Autowired
    Utils utils;

    public void insertSITxnDtl(Map<String, String> insertSITxnDtlMap) {


        siTxnDtl.setSubrSys(insertSITxnDtlMap.get("subSystem"));
        siTxnDtl.setSiTrnsID(insertSITxnDtlMap.get("txnId"));
        siTxnDtl.setBussFlow(Constants.BUSINESS_FLOW);
        siTxnDtl.setReqSts(insertSITxnDtlMap.getOrDefault("jobStatus",""));
        siTxnDtl.setRespDttm(utils.getCurrentTimestamp());

        if (insertSITxnDtlMap.get("jobType").equals(Constants.JOB_TYPE_INS)) {
            siTxnDtl.setId(null);
        }

        siTxnDtlRepository.save(siTxnDtl);

    }

}
