package com.nhnacademy.residentmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public interface ResidentResponseDto {

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
