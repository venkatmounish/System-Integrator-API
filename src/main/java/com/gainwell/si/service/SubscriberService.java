package com.gainwell.si.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gainwell.si.domain.ProviderInformation;
import com.gainwell.si.domain.SubscriberA;
import com.gainwell.si.domain.SubscriberB;
import com.gainwell.si.domain.SubscriberC;
import com.gainwell.si.utils.Constants;
import com.gainwell.si.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class SubscriberService {

    @Autowired
    SubscriberA subscriberA;

    @Autowired
    SubscriberB subscriberB;

    @Autowired
    SubscriberC subscriberC;

    @Autowired
    SITxnDtlService siTxnDtlService;

    @Autowired
    SiTransErrService siTransErrService;

    @Autowired
    SubscriberPayloadService subscriberPayloadService;

    @Autowired
    Utils utils;

    String payload;
    String jobStatus;

    ObjectMapper mapper = new ObjectMapper();

    @Async
    public void genSubAMsg(ProviderInformation providerInformation, String txnId) throws ExecutionException,
            InterruptedException, IOException {

        String providerTypeCode = providerInformation.getProviderType().getType().getProviderTypeCode();

        String jobType = Constants.JOB_TYPE_INS;

        Map<String, String> insertSITxnDtlMap = new HashMap<>();
        Map<String, String> insertsiTransErrMap = new HashMap<>();
        Map<String, String> insertSubPayloadMap = new HashMap<>();

        insertSITxnDtlMap.put("subSystem", Constants.SUBSCRIBERA);
        insertSITxnDtlMap.put("jobType", jobType);
        insertSITxnDtlMap.put("txnId", txnId);

        insertsiTransErrMap.put("subSystem", Constants.SUBSCRIBERA);
        insertsiTransErrMap.put("txnId", txnId);

        insertSubPayloadMap.put("subSystem", Constants.SUBSCRIBERA);

        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);

        jobType = Constants.JOB_TYPE_UPD;
        insertSITxnDtlMap.put("jobType", jobType);

        if (!providerTypeCode.equals("72")) {

            subscriberA.setProviderDemographics(providerInformation.getProviderDemographics());

            subscriberA.setProviderContact(providerInformation.getProviderContact());
            subscriberA.setProviderApplication(providerInformation.getProviderApplication());
            subscriberA.setProviderType(providerInformation.getProviderType());
            subscriberA.setProviderAffiliations(providerInformation.getProviderAffiliations());
            subscriberA.setProviderType(providerInformation.getProviderType());

            providerInformation.getProviderServiceLocation().getServiceLocation().setProviderRestriction(null);

            subscriberA.setProviderServiceLocation(providerInformation.getProviderServiceLocation());


            payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriberA);
            insertSubPayloadMap.put("payload", payload);

            subscriberPayloadService.insertSubPayload(insertSubPayloadMap);

            jobStatus = Constants.JOB_STS_SUC;
            // utils.saveAsFile(CompletableFuture.completedFuture(subscriberA).get(), jobStatus);

        } else {

            jobStatus = Constants.JOB_STS_FAIL;
            InputStream jsonSchemaStream = new ClassPathResource("SubAError_1.json").getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(jsonSchemaStream, baos);
            byte[] err1Bytes = baos.toByteArray();

            String err1Json = new String(err1Bytes, StandardCharsets.UTF_8);

            insertsiTransErrMap.put("errCd", "401");
            insertsiTransErrMap.put("errDtl", err1Json);

            siTransErrService.insertSiTransErr(insertsiTransErrMap);

            //  utils.saveAsFile(CompletableFuture.completedFuture(providerInformation).get(), jobStatus);
            //siTransErrService

        }


        insertSITxnDtlMap.put("jobStatus", jobStatus);
        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);


    }

    @Async
    public void genSubBMsg(ProviderInformation providerInformation, String txnId) throws ExecutionException, InterruptedException, JsonProcessingException {

        String jobStatus;
        String jobType = Constants.JOB_TYPE_INS;

        Map<String, String> insertSITxnDtlMap = new HashMap<>();
        Map<String, String> insertSubPayloadMap = new HashMap<>();

        insertSITxnDtlMap.put("subSystem", Constants.SUBSCRIBERB);
        insertSITxnDtlMap.put("jobType", jobType);
        insertSITxnDtlMap.put("txnId", txnId);

        insertSubPayloadMap.put("subSystem", Constants.SUBSCRIBERB);

        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);

        jobType = Constants.JOB_TYPE_UPD;
        insertSITxnDtlMap.put("jobType", jobType);

        subscriberB.setProviderDemographics(providerInformation.getProviderDemographics());
        subscriberB.setProviderAffiliations(providerInformation.getProviderAffiliations());

        providerInformation.getProviderServiceLocation().getServiceLocation().setServiceLocationAddress(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setServiceLocationContact(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderLicense(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderCertification(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderIdentifier(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderFacility(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderTaxonomy(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderSpecialty(null);
        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderRestriction(null);

        subscriberB.setProviderServiceLocation(providerInformation.getProviderServiceLocation());

        payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriberB);
        insertSubPayloadMap.put("payload", payload);

        subscriberPayloadService.insertSubPayload(insertSubPayloadMap);

        jobStatus = Constants.JOB_STS_SUC;
        insertSITxnDtlMap.put("jobStatus", jobStatus);

        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);
        // utils.saveAsFile(CompletableFuture.completedFuture(subscriberB).get(), "success");

    }

    @Async
    public void genSubCMsg(ProviderInformation providerInformation, String txnId) throws ExecutionException, InterruptedException, JsonProcessingException {

        String jobStatus;
        String jobType = Constants.JOB_TYPE_INS;

        Map<String, String> insertSITxnDtlMap = new HashMap<>();
        Map<String, String> insertSubPayloadMap = new HashMap<>();

        insertSITxnDtlMap.put("subSystem", Constants.SUBSCRIBERC);
        insertSITxnDtlMap.put("jobType", jobType);
        insertSITxnDtlMap.put("txnId", txnId);

        insertSubPayloadMap.put("subSystem", Constants.SUBSCRIBERC);

        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);

        jobType = Constants.JOB_TYPE_UPD;
        insertSITxnDtlMap.put("jobType", jobType);

        subscriberC.setProviderDemographics(providerInformation.getProviderDemographics());
        subscriberC.setProviderAddress(providerInformation.getProviderAddress());
        subscriberC.setProviderContact(providerInformation.getProviderContact());
        subscriberC.setProviderApplication(providerInformation.getProviderApplication());
        subscriberC.setProviderAlternateIdentifiers(providerInformation.getProviderAlternateIdentifiers());
        subscriberC.setProviderType(providerInformation.getProviderType());
        subscriberC.setProviderAffiliations(providerInformation.getProviderAffiliations());
        subscriberC.setProviderOwnership(providerInformation.getProviderOwnership());
        subscriberC.setOwnerRelationship(providerInformation.getOwnerRelationship());
        subscriberC.setProviderManagedEmployees(providerInformation.getProviderManagedEmployees());
        subscriberC.setProviderBusinessStatus(providerInformation.getProviderBusinessStatus());
        subscriberC.setProviderTaxonomyClassification(providerInformation.getProviderTaxonomyClassification());
        subscriberC.setProviderProgramAffiliations(providerInformation.getProviderProgramAffiliations());
        subscriberC.setProviderEFTEnrollment(providerInformation.getProviderEFTEnrollment());
        subscriberC.setProviderAffiliations(providerInformation.getProviderAffiliations());
        subscriberC.setProviderServiceLocation(providerInformation.getProviderServiceLocation());

        payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(subscriberC);
        insertSubPayloadMap.put("payload", payload);

        subscriberPayloadService.insertSubPayload(insertSubPayloadMap);

        jobStatus = Constants.JOB_STS_SUC;
        insertSITxnDtlMap.put("jobStatus", jobStatus);

        siTxnDtlService.insertSITxnDtl(insertSITxnDtlMap);

        // utils.saveAsFile(CompletableFuture.completedFuture(subscriberC).get(), "success");

    }

}
