package com.nhnacademy.residentmanagementsystem.controller.restcontroller;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdCompositionResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdCompositionResponseResidentDto;
import com.nhnacademy.residentmanagementsystem.service.HouseholdResidentCompositionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseholdCompositionResidentController {

    private final HouseholdResidentCompositionService householdResidentCompositionService;

    public HouseholdCompositionResidentController(HouseholdResidentCompositionService householdResidentCompositionService) {
        this.householdResidentCompositionService = householdResidentCompositionService;
    }

    @PostMapping("/composition")
    HouseholdCompositionResponseResidentDto registerHouseholdCompositionResident(@RequestBody HouseholdCompositionResidentRequestDto householdCompositionResidentRequestDto) {
        return householdResidentCompositionService.registerHouseholdResidentCompositions(householdCompositionResidentRequestDto);
    }

    @DeleteMapping(value = "/composition/{serialNum}/delete/{householdSerialNum}",produces = "application/json; charset=utf8")
    String deleteHouseholdResidentCompositions(@PathVariable Long serialNum
                                            , @PathVariable Long householdSerialNum) {
        return householdResidentCompositionService.deleteHouseholdResidentCompositions(serialNum, householdSerialNum);
    }
}
