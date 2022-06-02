package com.nhnacademy.residentmanagementsystem.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HouseholdCompositionResidentRequestDto {
    Long householdSerialNumber;
    Long residentSerialNumber;
    LocalDate reportDate;
    String householdRelationshipCode;
    String householdCompositionChangeReasonCode;
}
