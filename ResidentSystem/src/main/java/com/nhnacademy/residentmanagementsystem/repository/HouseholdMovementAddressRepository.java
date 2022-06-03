package com.nhnacademy.residentmanagementsystem.repository;

import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdMovementAddressResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress
        , HouseholdMovementAddress.HouseholdMovementAddressPk> {

    HouseholdMovementAddressResponseDto findByHouseholdMovementAddressPk(HouseholdMovementAddress.HouseholdMovementAddressPk householdMovementAddressPk);

}
