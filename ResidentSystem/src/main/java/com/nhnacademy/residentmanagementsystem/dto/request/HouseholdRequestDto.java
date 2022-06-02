package com.nhnacademy.residentmanagementsystem.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HouseholdRequestDto {
    Long HouseholdSerialNumber;
    Long HouseholdResidentSerialNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate HouseholdCompositionDate;
    String HouseholdCompositionReasonCode;
    String CurrentHouseMovementAddress;
}
