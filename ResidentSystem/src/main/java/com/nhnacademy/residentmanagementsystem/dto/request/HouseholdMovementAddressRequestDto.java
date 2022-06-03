package com.nhnacademy.residentmanagementsystem.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HouseholdMovementAddressRequestDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate houseMovementReportDate;
    String houseMovementAddress;
    String lastAddressYn;
}
