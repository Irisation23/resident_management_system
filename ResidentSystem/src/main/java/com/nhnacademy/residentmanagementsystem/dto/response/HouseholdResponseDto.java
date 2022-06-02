package com.nhnacademy.residentmanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface HouseholdResponseDto {
    Long getHouseholdSerialNumber();
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getHouseholdCompositionDate();
    String getHouseholdCompositionReasonCode();
    String getCurrentHouseMovementAddress();
    ResidentResponse getResident();

    interface ResidentResponse{
        Long getResidentSerialNumber();
        String getName();
        String getResidentRegistrationNumber();
        String getGenderCode();

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime getBirthDate();
        String getBirthPlaceCode();
        String getRegistrationBaseAddress();

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime getDeathDate();

        String getDeathPlaceCode();
        String getDeathPlaceAddress();
    }

}
