package com.gainwell.si.service;

import com.gainwell.si.Repository.SIRequestsRepository;
import com.gainwell.si.domain.Envelope;
import com.gainwell.si.domain.Root;
import com.gainwell.si.domain.SIRequests;
import com.gainwell.si.utils.Constants;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class SIRequestsService {

    @Autowired
    SIRequestsRepository siRequestsRepository;

    @Autowired
    SIRequests siRequests;

    @Autowired
    ParseReqJson parseReqJson;

    @Autowired
    Utils utils;


    //@Transactional
    public void insertSIRequests(String requestJson) {

        Root root = parseReqJson.parseJson(requestJson);

        //siRequestsRepository.flush();

        siRequests.setModuleTxnID(root.getCreateProvider().getMessageHeader().getModuleTransactionId());
        siRequests.setSiTxnKey(root.getCreateProvider().getMessageHeader().getSITransactionKey());

        siRequests.setBusinessFlow(Constants.BUSINESS_FLOW);
        siRequests.setMethod(Constants.METHOD);

        siRequests.setRequestorSystem(root.getCreateProvider().getMessageHeader().getRequestorSystem());
        siRequests.setUniqueStateCode(root.getCreateProvider().getMessageHeader().getStateCode());

        siRequests.setRequestTimestamp(utils.getCurrentTimestamp());

        System.out.println(siRequests);
        siRequests.setId(null);
        siRequestsRepository.saveAndFlush(siRequests);


    }
}
