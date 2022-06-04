package com.nhnacademy.residentmanagementsystem.controller.restcontroller;

import com.nhnacademy.residentmanagementsystem.dto.request.FamilyRelationshipRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.FamilyRelationshipResponseDto;
import com.nhnacademy.residentmanagementsystem.service.FamilyRelationshipService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamilyController {
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @PostMapping(value = "/residents/{serialNumber}/relationship")
    FamilyRelationshipResponseDto doRegisterFamilyRelationship(@PathVariable("serialNumber") Long serialNumber,
            @RequestBody FamilyRelationshipRequestDto familyRelationshipRequestDto) {
        return familyRelationshipService.registerFamilyRelationship(serialNumber, familyRelationshipRequestDto);
    }

    @PutMapping(value = "/residents/{serialNumber}/relationship/{familySerialNumber}")
    FamilyRelationshipResponseDto updateFamilyRelationship(@PathVariable("serialNumber") Long serialNumber,
                                                           @PathVariable("familySerialNumber") Long familySerialNumber,
                                                           @RequestBody FamilyRelationshipRequestDto familyRelationshipRequestDto) {
        return familyRelationshipService.updateFamilyRelationship(serialNumber,familySerialNumber,familyRelationshipRequestDto);
    }

    @DeleteMapping(value = "/residents/{serialNumber}/relationship/{familySerialNumber}",produces = "application/json; charset=utf8")
    String deleteFamilyRelationship(@PathVariable("serialNumber") Long serialNumber,
                                    @PathVariable("familySerialNumber") Long familySerialNumber) {
        return familyRelationshipService.deleteFamilyRelationship(serialNumber,familySerialNumber);
    }
}
