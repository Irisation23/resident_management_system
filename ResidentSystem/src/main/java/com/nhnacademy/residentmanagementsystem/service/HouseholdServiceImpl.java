package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdResponseDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Household;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindHouseholdException;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.HouseholdRepository;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;
    private final ResidentRepository residentRepository;

    public HouseholdServiceImpl(HouseholdRepository householdRepository, ResidentRepository residentRepository) {
        this.householdRepository = householdRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public HouseholdResponseDto registerHousehold(HouseholdRequestDto householdRequestDto) {
        Resident householdResident = residentRepository.findById(householdRequestDto.getHouseholdResidentSerialNumber())
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 없습니다."));

        Household household = householdRepository.findById(householdRequestDto.getHouseholdSerialNumber())
                .orElse(new Household(householdRequestDto.getHouseholdSerialNumber()
                        , householdRequestDto.getHouseholdCompositionDate()
                        , householdRequestDto.getHouseholdCompositionReasonCode()
                        , householdRequestDto.getCurrentHouseMovementAddress()
                        , householdResident));
        householdRepository.save(household);

        return householdRepository.findByHouseholdSerialNumber(householdRequestDto.getHouseholdSerialNumber());
    }

    @Override
    public String deleteHousehold(Long householdSerialNumber) {
        Household household = householdRepository.findById(householdSerialNumber)
                .orElseThrow(() -> new NotFindHouseholdException("해당 세대주 정보는 없습니다."));
        householdRepository.delete(household);
        return "삭제 완료 ^^77";
    }
}

