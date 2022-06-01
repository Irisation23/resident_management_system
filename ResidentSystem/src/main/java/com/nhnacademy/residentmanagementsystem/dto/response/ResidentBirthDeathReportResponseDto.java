package com.nhnacademy.residentmanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ResidentBirthDeathReportResponseDto {

    BirthDeathReportResidentPkResponseDto getBirthDeathReportResidentPk();

    interface BirthDeathReportResidentPkResponseDto {

        String getBirthDeathTypeCode();
        Long getReportResidentSerialNumber();
        Long getResidentSerialNumber();
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDeathReportDate();
    String getBirthReportQualificationsCode();
    String getDeathReportQualificationsCode();
    String getEmailAddress();
    String getPhoneNumber();
    ResidentDto getResident();
    interface ResidentDto{
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
