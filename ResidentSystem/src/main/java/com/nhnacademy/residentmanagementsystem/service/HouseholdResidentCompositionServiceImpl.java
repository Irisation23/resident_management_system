package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.HouseholdCompositionResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.HouseholdCompositionResponseResidentDto;
import com.nhnacademy.residentmanagementsystem.entity.Household;
import com.nhnacademy.residentmanagementsystem.entity.HouseholdCompositionResident;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindHouseholdException;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.HouseholdCompositionResidentRepository;
import com.nhnacademy.residentmanagementsystem.repository.HouseholdRepository;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;

@Service
public class HouseholdResidentCompositionServiceImpl implements HouseholdResidentCompositionService {

    private final ResidentRepository residentRepository;
    private final HouseholdRepository householdRepository;
    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;


    public HouseholdResidentCompositionServiceImpl(ResidentRepository residentRepository, HouseholdRepository householdRepository, HouseholdCompositionResidentRepository householdCompositionResidentRepository) {
        this.residentRepository = residentRepository;
        this.householdRepository = householdRepository;
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
    }

    @Override
    public HouseholdCompositionResponseResidentDto registerHouseholdResidentCompositions(HouseholdCompositionResidentRequestDto householdResidentCompositionRequestDto) {
        Resident baseResident = residentRepository.findById(householdResidentCompositionRequestDto.getResidentSerialNumber())
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 없습니다."));

        Household baseHousehold = householdRepository.findById(householdResidentCompositionRequestDto.getHouseholdSerialNumber())
                .orElseThrow(() -> new NotFindHouseholdException("해당 세대는 없습니다."));

        HouseholdCompositionResident.HouseholdCompositionResidentPk householdCompositionResidentPk =
                new HouseholdCompositionResident.HouseholdCompositionResidentPk(householdResidentCompositionRequestDto.getHouseholdSerialNumber()
                        , householdResidentCompositionRequestDto.getResidentSerialNumber());

        HouseholdCompositionResident householdCompositionResident =
                new HouseholdCompositionResident(householdCompositionResidentPk
                        , householdResidentCompositionRequestDto.getReportDate()
        , householdResidentCompositionRequestDto.getHouseholdRelationshipCode()
                , householdResidentCompositionRequestDto.getHouseholdCompositionChangeReasonCode()
                        , baseResident
                        , baseHousehold);

        householdCompositionResidentRepository.save(householdCompositionResident);


        return householdCompositionResidentRepository.findByHouseholdCompositionResidentPk(householdCompositionResidentPk);
    }

    @Override
    public String deleteHouseholdResidentCompositions(Long serialNum, Long householdSerialNum) {

        HouseholdCompositionResident.HouseholdCompositionResidentPk householdCompositionResidentPk =
                new HouseholdCompositionResident.HouseholdCompositionResidentPk(householdSerialNum
                        ,serialNum);

        householdCompositionResidentRepository.deleteById(householdCompositionResidentPk);

        return "세대구성 삭제 완료! 찡긋 ^^77";
    }
}
