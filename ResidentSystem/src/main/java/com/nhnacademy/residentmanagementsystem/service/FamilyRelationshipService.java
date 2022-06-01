package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.FamilyRelationshipRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.FamilyRelationshipResponseDto;

public interface FamilyRelationshipService {

    FamilyRelationshipResponseDto registerFamilyRelationship(Long serialNumber, FamilyRelationshipRequestDto familyRelationshipRequestDto);

    FamilyRelationshipResponseDto updateFamilyRelationship(Long serialNumber, Long familySerialNumber, FamilyRelationshipRequestDto familyRelationshipRequestDto);

    String deleteFamilyRelationship(Long serialNumber, Long familySerialNumber);
}
