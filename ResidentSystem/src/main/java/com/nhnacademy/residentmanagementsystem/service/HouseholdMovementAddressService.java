package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdMovementAddressRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdMovementAddressResponseDto;

import java.time.LocalDate;

public interface HouseholdMovementAddressService {
    HouseholdMovementAddressResponseDto registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRequestDto householdMovementAddressRequestDto);

    HouseholdMovementAddressResponseDto updateHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDateFormat, HouseholdMovementAddressRequestDto householdMovementAddressRequestDto);

    String deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDateFormat);
}
