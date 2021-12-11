package com.gainwell.si.service;

import com.gainwell.si.repository.SiTransErrRepository;
import com.gainwell.si.domain.SiTransErr;
import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SiTransErrService {

    @Autowired
    SiTransErrRepository siTransErrRepository;

    @Autowired
    SiTransErr siTransErr;

    @Autowired
    Utils utils;


    public void insertSiTransErr(Map<String, String> insertsiTransErrMap) {


        siTransErr.setSubrSys(insertsiTransErrMap.get("subSystem"));
        siTransErr.setSiTrnsID(insertsiTransErrMap.get("txnId"));
        siTransErr.setErrCd(insertsiTransErrMap.get("errCd"));
        siTransErr.setErrDtl(insertsiTransErrMap.get("errDtl"));
        siTransErr.setErrRespDttm(utils.getCurrentTimestamp());

        siTransErr.setId(null);

        siTransErrRepository.save(siTransErr);

    }
    
}
