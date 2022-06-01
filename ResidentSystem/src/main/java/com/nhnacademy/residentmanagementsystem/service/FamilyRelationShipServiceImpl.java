package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.FamilyRelationshipRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.FamilyRelationshipResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.FamilyRelationship;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindFamilyRelationException;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.FamilyRelationshipRepository;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyRelationShipServiceImpl implements FamilyRelationshipService {

    private final ResidentRepository residentRepository;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public FamilyRelationShipServiceImpl(ResidentRepository residentRepository, FamilyRelationshipRepository familyRelationshipRepository) {
        this.residentRepository = residentRepository;
        this.familyRelationshipRepository = familyRelationshipRepository;
    }

    @Override
    public FamilyRelationshipResponseDto registerFamilyRelationship(Long serialNumber, FamilyRelationshipRequestDto familyRelationshipRequestDto) {

        Resident baseResident = residentRepository.findById(serialNumber)
                .orElseThrow(() -> new NotFindResidentException("해당 기준주민은 존재하지 않습니다."));

        FamilyRelationship.FamilyRelationshipPk familyRelationshipPk =
                new FamilyRelationship.FamilyRelationshipPk(familyRelationshipRequestDto.getFamilySerialNumber(), serialNumber);

        FamilyRelationship familyRelationship = new FamilyRelationship(familyRelationshipPk, familyRelationshipRequestDto.getRelationShip(), baseResident);

        // FamilyRelationship.FamilyRelationshipPk registerFamilyRelationshipPk = familyRelationshipRepository.save(familyRelationship).getFamilyRelationshipPk();

        familyRelationshipRepository.save(familyRelationship);
        return familyRelationshipRepository.findByFamilyRelationshipPk(familyRelationshipPk);
    }

    @Override
    public FamilyRelationshipResponseDto updateFamilyRelationship(Long serialNumber, Long familySerialNumber, FamilyRelationshipRequestDto familyRelationshipRequestDto) {

        Resident baseResident = residentRepository.findById(serialNumber)
                .orElseThrow(() -> new NotFindResidentException("해당 기준주민은 존재하지 않습니다."));

        FamilyRelationship.FamilyRelationshipPk familyRelationshipPk =
                new FamilyRelationship.FamilyRelationshipPk(familySerialNumber,serialNumber);

        FamilyRelationship familyRelationship = new FamilyRelationship(familyRelationshipPk, familyRelationshipRequestDto.getRelationShip(),baseResident);

        if(isFamily(familyRelationshipRequestDto)) {
            familyRelationship.setFamilyRelationshipCode(familyRelationshipRequestDto.getRelationShip());
        }

        familyRelationshipRepository.save(familyRelationship);

        return familyRelationshipRepository.findByFamilyRelationshipPk(familyRelationshipPk);
    }

    @Override
    public String deleteFamilyRelationship(Long serialNumber, Long familySerialNumber) {
        FamilyRelationship.FamilyRelationshipPk familyRelationshipPk =
                new FamilyRelationship.FamilyRelationshipPk(familySerialNumber, serialNumber);

        FamilyRelationship deleteFamilyRelationship = familyRelationshipRepository.findById(familyRelationshipPk)
                .orElseThrow(() -> new NotFindFamilyRelationException("해당 가족관계는 존재하지 않습니다."));

        familyRelationshipRepository.delete(deleteFamilyRelationship);

        return "삭제 완료 ^_^ ㅎㅎ";
    }

    private boolean isFamily(FamilyRelationshipRequestDto familyRelationshipRequestDto) {
        return familyRelationshipRequestDto.getRelationShip() != null;
    }

}
