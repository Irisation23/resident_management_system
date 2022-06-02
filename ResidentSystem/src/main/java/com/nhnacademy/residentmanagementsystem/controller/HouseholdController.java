package com.nhnacademy.residentmanagementsystem.controller;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdResponseDto;
import com.nhnacademy.residentmanagementsystem.service.HouseholdService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping("/household")
    HouseholdResponseDto registerHousehold(@RequestBody HouseholdRequestDto householdRequestDto){
        return householdService.registerHousehold(householdRequestDto);
    }

    @DeleteMapping(value = "/household/{householdSerialNumber}",produces = "application/json; charset=utf8")
    String deleteHousehold(@PathVariable("householdSerialNumber") Long householdSerialNumber){
        return householdService.deleteHousehold(householdSerialNumber);
    }
}
