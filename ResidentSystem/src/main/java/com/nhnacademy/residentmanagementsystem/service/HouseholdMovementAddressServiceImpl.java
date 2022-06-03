package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdMovementAddressRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdMovementAddressResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Household;
import com.nhnacademy.residentmanagementsystem.entity.HouseholdMovementAddress;
import com.nhnacademy.residentmanagementsystem.exception.NotFindHouseholdException;
import com.nhnacademy.residentmanagementsystem.exception.NotFindHouseholdMovementAddress;
import com.nhnacademy.residentmanagementsystem.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.residentmanagementsystem.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {

    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;

    public HouseholdMovementAddressServiceImpl(HouseholdRepository householdRepository, HouseholdMovementAddressRepository householdMovementAddressRepository) {
        this.householdRepository = householdRepository;
        this.householdMovementAddressRepository = householdMovementAddressRepository;
    }

    @Override
    public HouseholdMovementAddressResponseDto registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRequestDto householdMovementAddressRequestDto) {

        Household baseHousehold = householdRepository.findById(householdSerialNumber)
                .orElseThrow(() -> new NotFindHouseholdException("해당 세대는 없습니다."));

        HouseholdMovementAddress.HouseholdMovementAddressPk householdMovementAddressPk =
                new HouseholdMovementAddress.HouseholdMovementAddressPk(householdMovementAddressRequestDto.getHouseMovementReportDate()
                , householdSerialNumber);

        HouseholdMovementAddress householdMovementAddress =
                new HouseholdMovementAddress(householdMovementAddressPk
                        , householdMovementAddressRequestDto.getHouseMovementAddress()
                        , householdMovementAddressRequestDto.getLastAddressYn()
                        , baseHousehold);

        householdMovementAddressRepository.save(householdMovementAddress);

        return householdMovementAddressRepository.findByHouseholdMovementAddressPk(householdMovementAddressPk);
    }

    @Override
    public HouseholdMovementAddressResponseDto updateHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDateFormat, HouseholdMovementAddressRequestDto householdMovementAddressRequestDto) {

        HouseholdMovementAddress.HouseholdMovementAddressPk householdMovementAddressPk =
                new HouseholdMovementAddress.HouseholdMovementAddressPk(reportDateFormat
                        , householdSerialNumber);

        HouseholdMovementAddress updateHouseholdMovementAddress = householdMovementAddressRepository.findById(householdMovementAddressPk)
                .orElseThrow(() -> new NotFindHouseholdMovementAddress("해당 세대 이동주소는 없습니다."));

        updateHouseholdMovementAddress.setHouseMovementAddress(updateHouseholdMovementAddress.getHouseMovementAddress());

        householdMovementAddressRepository.save(updateHouseholdMovementAddress);

        return householdMovementAddressRepository.findByHouseholdMovementAddressPk(householdMovementAddressPk);
    }

    @Override
    public String deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDateFormat) {
        HouseholdMovementAddress.HouseholdMovementAddressPk householdMovementAddressPk =
                new HouseholdMovementAddress.HouseholdMovementAddressPk(reportDateFormat
                        , householdSerialNumber);

        householdMovementAddressRepository.deleteById(householdMovementAddressPk);
        return "세대 전입주소 삭제완료 ^^77";
    }
}
