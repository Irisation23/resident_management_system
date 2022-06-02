package com.nhnacademy.residentmanagementsystem.repository;

import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household ,
        Long> {
    HouseholdResponseDto findByHouseholdSerialNumber(Long householdSerialNumber);
}
