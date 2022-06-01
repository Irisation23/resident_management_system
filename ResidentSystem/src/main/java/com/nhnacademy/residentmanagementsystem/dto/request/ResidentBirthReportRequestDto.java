package com.nhnacademy.residentmanagementsystem.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ResidentBirthReportRequestDto {
    Long serialNum;
    String name;
    String residentRegistrationNum;
    String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate;
    String birthPlace;
    String registrationBaseAddress;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate reportDate;
    String birthReportQualifications;
    String emailAddress;
    String phoneNumber;
}
