package com.gainwell.si.service;

import com.gainwell.si.repository.SIRequestsRepository;
import com.gainwell.si.domain.Root;
import com.gainwell.si.domain.SIRequests;
import com.gainwell.si.utils.Constants;
import com.gainwell.si.utils.ParseReqJson;
import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Root root = null;
        root = parseReqJson.parseJson(requestJson);

        //siRequestsRepository.flush();

        siRequests.setModTrnsID(root.getCreateProvider().getMessageHeader().getModuleTransactionId());
        siRequests.setSiTrnsID(root.getCreateProvider().getMessageHeader().getSITransactionKey());

        siRequests.setBussFlow(Constants.BUSINESS_FLOW);
        siRequests.setMethod(Constants.METHOD);

        siRequests.setReqSys(root.getCreateProvider().getMessageHeader().getRequestorSystem());
        siRequests.setStCd(root.getCreateProvider().getMessageHeader().getStateCode());

        siRequests.setReqDttm(utils.getCurrentTimestamp());

        System.out.println(siRequests);
        siRequests.setId(null);
        siRequestsRepository.saveAndFlush(siRequests);


    }
}
