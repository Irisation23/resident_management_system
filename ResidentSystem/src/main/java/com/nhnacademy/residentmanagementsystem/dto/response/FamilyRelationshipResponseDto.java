package com.nhnacademy.residentmanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface FamilyRelationshipResponseDto {

    FamilyRelationshipPkResponseDto getFamilyRelationshipPk();

    interface FamilyRelationshipPkResponseDto {
        Long getFamilyResidentSerialNumber();
        Long getBaseResidentSerialNumber();
    }

    String getFamilyRelationshipCode();
    ResidentDto getResident();
    
    interface ResidentDto {
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
