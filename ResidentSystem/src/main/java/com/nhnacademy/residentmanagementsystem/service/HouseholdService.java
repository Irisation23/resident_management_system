package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdResponseDto;

public interface HouseholdService {
    HouseholdResponseDto registerHousehold(HouseholdRequestDto householdRequestDto);

    String deleteHousehold(Long householdSerialNumber);
}
