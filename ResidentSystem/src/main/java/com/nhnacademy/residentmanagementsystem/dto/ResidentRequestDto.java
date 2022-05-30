package com.nhnacademy.residentmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResidentRequestDto {

    Long serialNum;
    String name;
    String residentRegistrationNum;
    String gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate;

    String birthPlace;
    String registrationBaseAddress;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime deathDate;

    String deathPlace;
    String deathPlaceAddress;
}
