package com.gainwell.si.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gainwell.si.domain.*;
import com.gainwell.si.service.CreateProviderService;
import com.gainwell.si.service.SIRequestsService;
import com.gainwell.si.service.SchemaValidateService;
import com.gainwell.si.utils.ValidateSchema;
import com.networknt.schema.ValidationMessage;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@RestController
@EnableAutoConfiguration
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Api(value = "Submit Provider Information", tags = "API call to submit provider information")
@Tag(name = "Process Provider Information", description = "API call to process provider information")
@OpenAPIDefinition(tags = {
        @Tag(name = "widget", description = "Widget operations."),
        @Tag(name = "gasket", description = "Operations related to gaskets")
})
public class CreateProviderController {


    @Autowired
    SchemaValidateService schemaValidateService;

    @Autowired
    SIRequestsService siRequestsService;

    @Autowired
    CreateProviderService createProviderService;

    //   @Value("${value.from.file}")
    private String sampleJson;

    // @Example(value = {@ExampleProperty(mediaType = "application/json", value = "{}")})

    @ApiOperation(value = "Submit Provider Information", response = CreateProviderResponse.class)
    @Tag(name = "Process Provider Information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Provider info submitted"),
            @ApiResponse(code = 202, message = "Provider info processed"),
            @ApiResponse(code = 401, message = "You are not authorized to perform this operation"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping(value = "/api/createProvider", consumes = "application/json", produces = "application/json")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ResponseEntity<Object> createProvider(@ApiParam(name = "requestJson",
            type = "json",
            value = "Provider Information",
            example = "{\n" +
                    "\n" +
                    "\t\t\t\"CreateProvider\": {\n" +
                    "\t\t\t\t\"MessageHeader\": {\n" +
                    "\t\t\t\t\t\"BusinessFlow\": \"CreateProvider\",\n" +
                    "\t\t\t\t\t\"StateCode\": \"OH\",\n" +
                    "\t\t\t\t\t\"RequestorSystem\": \"OH PRSS\",\n" +
                    "\t\t\t\t\t\"ModuleTransactionId\": \"68fe4567832987ed68332190\",\n" +
                    "\t\t\t\t\t\"RequestTimestamp\": \"2015-06-02T14:30:47\",\n" +
                    "\t\t\t\t\t\"SITransactionKey\": \"54f3b89e5f6e0d0300059861\"\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"Payload\": {\n" +
                    "\t\t\t\t\t\"ProviderInformation\": {\n" +
                    "\t\t\t\t\t\t\"ProviderDemographics\": {\n" +
                    "\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\"ProviderId\": \"Prov624342\",\n" +
                    "\t\t\t\t\t\t\t\"TaxId\": {\n" +
                    "\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\"ProviderRoleCode\": \"A\",\n" +
                    "\t\t\t\t\t\t\t\"NationalProviderIdentifier\": \"001CAP002\",\n" +
                    "\t\t\t\t\t\t\t\"FirstName\": \"John\",\n" +
                    "\t\t\t\t\t\t\t\"MiddleName\": \"J\",\n" +
                    "\t\t\t\t\t\t\t\"LastName\": \"Jacob\",\n" +
                    "\t\t\t\t\t\t\t\"Prefix\": \"Mr\",\n" +
                    "\t\t\t\t\t\t\t\"Suffix\": \"II\",\n" +
                    "\t\t\t\t\t\t\t\"SSN\": \"890030000\",\n" +
                    "\t\t\t\t\t\t\t\"Gender\": \"M\",\n" +
                    "\t\t\t\t\t\t\t\"EntityType\": \"INDV\",\n" +
                    "\t\t\t\t\t\t\t\"ProviderName\": \"FamilyHealth\",\n" +
                    "\t\t\t\t\t\t\t\"LegalProviderName\": \"Pinnacle\",\n" +
                    "\t\t\t\t\t\t\t\"ProviderBusinessName\": \"Star fisheries\",\n" +
                    "\t\t\t\t\t\t\t\"ProviderTaxName\": \"Star fisheries Inc\",\n" +
                    "\t\t\t\t\t\t\t\"TeachingIndicator\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\"OwnershipCode\": \"19\",\n" +
                    "\t\t\t\t\t\t\t\"ProviderProfitStatusCode\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\"NewPatientIndicator\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\"EnrollmentType\": \"BA\",\n" +
                    "\t\t\t\t\t\t\t\"EffectiveDate\": \"2014-10-25\",\n" +
                    "\t\t\t\t\t\t\t\"EndDate\": \"2020-06-02\",\n" +
                    "\t\t\t\t\t\t\t\"DateOfBirth\": \"2013-06-02\",\n" +
                    "\t\t\t\t\t\t\t\"DateOfDeath\": {\n" +
                    "\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\"ProvDemographicsSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderAddress\": {\n" +
                    "\t\t\t\t\t\t\t\"Address\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"AddressType\": \"MA\",\n" +
                    "\t\t\t\t\t\t\t\t\"AddressLine1\": \"123\",\n" +
                    "\t\t\t\t\t\t\t\t\"AddressLine2\": \"XYZ\",\n" +
                    "\t\t\t\t\t\t\t\t\"City\": \"DAYTON\",\n" +
                    "\t\t\t\t\t\t\t\t\"State\": \"OH\",\n" +
                    "\t\t\t\t\t\t\t\t\"CountyCode\": \"12\",\n" +
                    "\t\t\t\t\t\t\t\t\"ZipCode5\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\"ZipCode4\": \"1234\",\n" +
                    "\t\t\t\t\t\t\t\t\"Country\": \"USA\",\n" +
                    "\t\t\t\t\t\t\t\t\"BorderStateIndicator\": \"7\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2016-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2029-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvAddressSrcKey\": \"12345678-1234-1234-1234-123456789012\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderContact\": {\n" +
                    "\t\t\t\t\t\t\t\"Contact\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\"ContactType\": \"HP\",\n" +
                    "\t\t\t\t\t\t\t\t\"ContactDetail\": \"9812312\",\n" +
                    "\t\t\t\t\t\t\t\t\"ContactInstruction\": \"Work phone\",\n" +
                    "\t\t\t\t\t\t\t\t\"PreferredContactIndicator\": \"Y\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvContactSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderApplication\": {\n" +
                    "\t\t\t\t\t\t\t\"Application\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\"ApplicationId\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"ApplicationCreatedDate\": \"2013-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ApprovalDate\": \"2019-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"StatePlanEnrollCode\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"EnrollMethodCode\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvApplicationSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderAlternateIdentifiers\": {\n" +
                    "\t\t\t\t\t\t\t\"AlternateIdentifier\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\"AlternateIdType\": \"RN\",\n" +
                    "\t\t\t\t\t\t\t\t\"AlternateId\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2017-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2019-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvAlternateIdSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderType\": {\n" +
                    "\t\t\t\t\t\t\t\"Type\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderTypeCode\": \"22\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2017-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2019-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvTypeSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderAffiliations\": {\n" +
                    "\t\t\t\t\t\t\t\"Affiliations\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderId\": \"8901231221321\",\n" +
                    "\t\t\t\t\t\t\t\t\"NPI\": \"8901238091\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderAffiliationTypeCode\": \"BP\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2019-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2029-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvAffiliationSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderOwnership\": {\n" +
                    "\t\t\t\t\t\t\t\"OwnershipDetails\": {\n" +
                    "\t\t\t\t\t\t\t\t\"OwnerType\": \"D\",\n" +
                    "\t\t\t\t\t\t\t\t\"OwnPercentage\": \"33\",\n" +
                    "\t\t\t\t\t\t\t\t\"SanctionInd\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\t\"SanctionExplain\": \"N/A\",\n" +
                    "\t\t\t\t\t\t\t\t\"CriminalOffenseInd\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\t\"CriminalOffenseExplain\": \"N/A\",\n" +
                    "\t\t\t\t\t\t\t\t\"LicenseSuspendInd\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\t\"LicenseSuspendExplain\": \"N/A\",\n" +
                    "\t\t\t\t\t\t\t\t\"PenaltyInd\": \"Y\",\n" +
                    "\t\t\t\t\t\t\t\t\"PenaltyExplain\": \"Late payment\",\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"1997-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2037-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"OwnerIndividual\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"FirstName\": \"Mike\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"MiddleName\": \"B\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"LastName\": \"Tyler\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"DateOfBirth\": \"2000-10-06\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"SSN\": \"123456789\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"OwnerIndvSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProvOwnrDtlSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\"OwnerAddress\": {\n" +
                    "\t\t\t\t\t\t\t\t\"Address\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"AddressType\": \"MA\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"AddressLine1\": \"456\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"AddressLine2\": \"ABC\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"City\": \"DAYTON\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"State\": \"OH\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"CountyCode\": \"20\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"ZipCode5\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"ZipCode4\": \"1234\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"Country\": \"USA\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2016-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"EndDate\": \"2029-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\"ProvOwnrAdrsSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"OwnerRelationship\": {\n" +
                    "\t\t\t\t\t\t\t\"Relationship\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"Owner1SSN\": \"132456789\",\n" +
                    "\t\t\t\t\t\t\t\t\"Owner2OrgTaxIdNumber\": {\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"RelationType\": \"3\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2016-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2029-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"OwnrRltnshpSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderManagedEmployees\": {\n" +
                    "\t\t\t\t\t\t\t\"ManagedEmployee\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"FirstName\": \"James\",\n" +
                    "\t\t\t\t\t\t\t\t\"MiddleName\": \"H\",\n" +
                    "\t\t\t\t\t\t\t\t\"LastName\": \"Anderson\",\n" +
                    "\t\t\t\t\t\t\t\t\"ManageEmployeesType\": \"M\",\n" +
                    "\t\t\t\t\t\t\t\t\"DateOfBirth\": \"1966-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"SSN\": \"213421366\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2006-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2026-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvMngdEmplySrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderBusinessStatus\": {\n" +
                    "\t\t\t\t\t\t\t\"BusinessStatus\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"BusinessStatusCode\": \"82\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2006-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2020-10-30\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvBsnsStatusSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderTaxonomyClassification\": {\n" +
                    "\t\t\t\t\t\t\t\"TaxonomyClassification\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"ClassificationTypeCode\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"ClassificationCode\": \"103T00000X\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2006-06-18\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2020-07-09\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvTxnmyClsfctnSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderProgramAffiliations\": {\n" +
                    "\t\t\t\t\t\t\t\"ProgramAffiliation\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"AffiliatedProgramCode\": \"123\",\n" +
                    "\t\t\t\t\t\t\t\t\"API\": \"ABCD\",\n" +
                    "\t\t\t\t\t\t\t\t\"AffiliatedProgramId\": \"01\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"1996-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2006-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\"PgmAffltnSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderEFTEnrollment\": {\n" +
                    "\t\t\t\t\t\t\t\"EFTEnrollment\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"EFTEnrollmentId\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2013-04-30\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": {\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"FinancialInstitutionAccountNumber\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\"FinancialInstitutionAccountType\": \"Checking\",\n" +
                    "\t\t\t\t\t\t\t\t\"FinancialInstitutionName\": \"Institutional\",\n" +
                    "\t\t\t\t\t\t\t\t\"FinancialInstitutionRoutingNumber\": \"1234567\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactFirstName\": \"FirstName\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactLastName\": \"LastName\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactMiddleName\": \"MiddleName\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactPhoneNumber\": \"1234567890\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactPhoneNumberExtension\": \"412\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderContactTitle\": \"Manager\",\n" +
                    "\t\t\t\t\t\t\t\t\"EFTStatus\": \"23\",\n" +
                    "\t\t\t\t\t\t\t\t\"ProvEFTEnrollmentSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\"ProviderServiceLocation\": {\n" +
                    "\t\t\t\t\t\t\t\"ServiceLocation\": {\n" +
                    "\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\"LocationName\": \"DAYTON\",\n" +
                    "\t\t\t\t\t\t\t\t\"LocationCode\": \"RHIP\",\n" +
                    "\t\t\t\t\t\t\t\t\"OrgStateOwnedIndicator\": {\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"RAPrintIndicator\": {\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2009-08-25\",\n" +
                    "\t\t\t\t\t\t\t\t\"EndDate\": \"2015-10-30\",\n" +
                    "\t\t\t\t\t\t\t\t\"ServiceLocationAddress\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Address\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"AddressType\": \"90\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"AddressLine1\": \"Rich\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"AddressLine2\": \"\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"City\": \"DAYTON\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"State\": \"OH\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"CountyCode\": \"20\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ZipCode5\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ZipCode4\": \"1234\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"Country\": \"USA\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"BorderStateIndicator\": \"Y\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2015-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2019-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"Latitude\": \"1234\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"Longitude\": \"1234\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"SvcLctnAdrsSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ServiceLocationContact\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Contact\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ContactType\": \"EM\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ContactDetail\": \"office\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ContactInstruction\": \"Office email\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"PreferredContactIndicator\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"SvcLctnCntctSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderLicense\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"License\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"LicenseType\": \"MD\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"LicenseNumber\": \"444\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"LicenseeStateCode\": \"WY\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"LicenseIssueBoardNotes\": \"NA\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"Status\": \"Y\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"StatusReason\": \"NA\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2017-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2029-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvLicenseSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderCertification\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Certification\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"CertificateNumber\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"CertificateType\": \"58\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2017-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2047-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvCrtfctnSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderIdentifier\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Identifier\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Inactive\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"IdentifierTypeCode\": \"5\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"IssuingEntityID\": \"420\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"IdentifierID\": \"786\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2007-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2027-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvIdentifierSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderFacility\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Facility\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"BedTypeCode\": \"1\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"BedCount\": \"5\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2007-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2057-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvFacilitySrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderTaxonomy\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Taxonomy\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"TaxonomyCode\": \"103T00000X\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"PrimaryTaxonomyIndicator\": \"N\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2006-04-14\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2057-09-07\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvTxnmySrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderSpecialty\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Specialty\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"ACTIVE\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"SpecialtyCode\": \"49\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2016-10-20\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2018-11-22\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvSpcltySrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderType\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Type\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProviderTypeCode\": \"22\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2013-04-30\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": \"2025-11-02\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvTypeSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProviderRestriction\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\"Restriction\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RecordStatusCode\": \"Active\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ReviewReason\": \"ABC\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ReviewType\": \"A\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"RestrictionClass\": \"12345\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ClaimType\": \"D\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"IncludeExcludeIndicator\": \"Y\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"LowCode\": \"01\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"HighCode\": \"01\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EffectiveDate\": \"2009-01-27T19:17:57\",\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"EndDate\": {\n" +
                    "\t\t\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\t\t\"ProvRestrictionSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\t\t\t\"ProvSvcLocationSrcKey\": \"123\"\n" +
                    "\t\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t\t}\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t\n",
            required = true
    )
                                                 @RequestBody String requestJson) {
        //ResponseEntity<String>

        /*Set<ValidationMessage> validationResult = schemaValidator.validateJson("C:\\Users\\t158463\\Documents\\Gainwell\\SI\\providerJsonSchema.json",
                requestJson);*/
        ResponseEntity<Object> responseEntity = createProviderService.createProviderSvc(requestJson);


        return responseEntity;
        //  return envelope;
    }

}
