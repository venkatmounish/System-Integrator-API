package com.gainwell.si.utils;

import lombok.Data;

@Data
public class ErrorConstants  {

    private String MIN_LENGTH_VIOLATION = "expected minLength";
    private String MAX_LENGTH_VIOLATION = "expected maxLength";
    private String PATTERN_VIOLATION = "does not match pattern";
    private String DATA_TYPE_VIOLATION = "expected type";
    private String DEPENDENCY_VIOLATION = "is required";
    private String FORMAT_VIOLATION_OR_ENUM_VALIDATION_VIOLATION = "is not a valid";
    private String MANDATORY_FIELD_VIOLATION_OR_CONDITIONAL_VIOLATION = "required key";
    private String NUMBER_IS_LESS_THAN_VIOLATION = "is not greater or equal to";
    private String NUMBER_IS_GREATER_THAN_VIOLATION = "is not less or equal";
    private String EXCLUSIVE_NUMBER_IS_GREATER_THAN_VIOLATION = "is not less than";
    private String EXCLUSIVE_NUMBER_IS_LESS_THAN_VIOLATION = "is not greater than";
    private String MULTIPLE_OF_VIOLATION = "is not a multiple";



}
