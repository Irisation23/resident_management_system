package com.nhnacademy.residentmanagementsystem.controller;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdMovementAddressRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdMovementAddressResponseDto;
import com.nhnacademy.residentmanagementsystem.service.HouseholdMovementAddressService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class HouseholdMovementAddressController {

    private final HouseholdMovementAddressService householdMovementAddressService;

    public HouseholdMovementAddressController(HouseholdMovementAddressService householdMovementAddressService) {
        this.householdMovementAddressService = householdMovementAddressService;
    }

    @PostMapping("/household/{householdSerialNumber}/movement")
    public HouseholdMovementAddressResponseDto registerHouseholdMovementAddress(@PathVariable Long householdSerialNumber
            , @RequestBody HouseholdMovementAddressRequestDto householdMovementAddressRequestDto) {
        return householdMovementAddressService.registerHouseholdMovementAddress(householdSerialNumber, householdMovementAddressRequestDto);
    }

    @PutMapping("/household/{householdSerialNumber}/movement/{reportDate}")
    public HouseholdMovementAddressResponseDto updateHouseholdMovementAddress(@PathVariable Long householdSerialNumber
            , @PathVariable String reportDate
            , @RequestBody HouseholdMovementAddressRequestDto householdMovementAddressRequestDto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate reportDateFormat = LocalDate.parse(reportDate, formatter);
        return householdMovementAddressService.updateHouseholdMovementAddress(householdSerialNumber, reportDateFormat, householdMovementAddressRequestDto);
    }

    @DeleteMapping(value = "/household/{householdSerialNumber}/movement/{reportDate}",produces = "application/json; charset=utf8")
    public String deleteHouseholdMovementAddress(@PathVariable Long householdSerialNumber
            , @PathVariable String reportDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate reportDateFormat = LocalDate.parse(reportDate, formatter);
        return householdMovementAddressService.deleteHouseholdMovementAddress(householdSerialNumber, reportDateFormat);
    }

//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//    LocalDate reportDateFormat = LocalDate.parse(reportDate, formatter);

}
