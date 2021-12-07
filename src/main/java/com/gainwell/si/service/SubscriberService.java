package com.gainwell.si.service;

import com.gainwell.si.domain.ProviderInformation;
import com.gainwell.si.domain.SubscriberA;
import com.gainwell.si.domain.SubscriberB;
import com.gainwell.si.domain.SubscriberC;
import com.gainwell.si.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

@Service
public class SubscriberService {

    @Autowired
    SubscriberA subscriberA;

    @Autowired
    SubscriberB subscriberB;

    @Autowired
    SubscriberC subscriberC;

    @Autowired
    Utils utils;

    @Async
    public void genSubAMsg(ProviderInformation providerInformation) throws ExecutionException, InterruptedException {

        //  SubscriberA subscriberA = new SubscriberA();
        //  ServiceLocation serviceLocation = new ServiceLocation();
        //  System.out.println(providerInformation.getProviderDemographics());
        subscriberA.setProviderDemographics(providerInformation.getProviderDemographics());
        //    subscriberA.setProviderAddress(providerInformation.getProviderAddress());
        subscriberA.setProviderContact(providerInformation.getProviderContact());
        subscriberA.setProviderApplication(providerInformation.getProviderApplication());
        subscriberA.setProviderType(providerInformation.getProviderType());
        subscriberA.setProviderAffiliations(providerInformation.getProviderAffiliations());
        //   subscriberA.setProviderAddress(null);
        subscriberA.setProviderType(providerInformation.getProviderType());

        // subscriberA.getProviderServiceLocation().getServiceLocation().setServiceLocationAddress();


        providerInformation.getProviderServiceLocation().getServiceLocation().setProviderRestriction(null);
        subscriberA.setProviderServiceLocation(providerInformation.getProviderServiceLocation());

        System.out.println(subscriberA);
        System.out.println("before sleep");
        System.out.println("sub a" + utils.getCurrentTimestamp());
        sleep(20000);
        System.out.println("after sleep");
        System.out.println("sub a" + utils.getCurrentTimestamp());
        utils.saveAsFile(CompletableFuture.completedFuture(subscriberA).get());

        //  return CompletableFuture.completedFuture(subscriberA);
    }

    @Async
    public void genSubBMsg(ProviderInformation providerInformation) throws ExecutionException, InterruptedException {

        //SubscriberB subscriberB = new SubscriberB();
        //  ServiceLocation serviceLocation = new ServiceLocation();
        //  System.out.println(providerInformation.getProviderDemographics());
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

        System.out.println(subscriberB);
        utils.saveAsFile(CompletableFuture.completedFuture(subscriberB).get());
        System.out.println("sub b" + utils.getCurrentTimestamp());
        //return CompletableFuture.completedFuture(subscriberB);
    }

    @Async
    public void genSubCMsg(ProviderInformation providerInformation) throws ExecutionException, InterruptedException {

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

        utils.saveAsFile(CompletableFuture.completedFuture(subscriberC).get());

    }

}
