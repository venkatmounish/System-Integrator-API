package com.gainwell.si.service;

import com.gainwell.si.repository.SubscriberPayloadRepository;
import com.gainwell.si.domain.SubscriberPayload;
import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SubscriberPayloadService {

    @Autowired
    SubscriberPayloadRepository subscriberPayloadRepository;

    @Autowired
    SubscriberPayload subscriberPayload;

    @Autowired
    Utils utils;

    public void insertSubPayload(Map<String, String> insertSubPayloadMap) {


        subscriberPayload.setSubrSys(insertSubPayloadMap.get("subSystem"));
        subscriberPayload.setPayload(insertSubPayloadMap.get("payload"));
        subscriberPayload.setRespDttm(utils.getCurrentTimestamp());

        subscriberPayload.setId(null);

        subscriberPayloadRepository.save(subscriberPayload);

    }
}
