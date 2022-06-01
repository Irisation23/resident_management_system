package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentServiceImpl implements ResidentService{

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public int countToResidentByName(String name) {
        return residentRepository.countByNameLike(name);
    }

    @Override
    public int countToUpdateResidentByName(String name, Long residentSerialNumber) {
        return residentRepository.updateResidentName(name,residentSerialNumber);
    }

    @Override
    @Transactional
    public ResidentResponseDto registerResident(ResidentRequestDto residentRequestDto) {

        Resident resident = Resident.builder()
                .residentSerialNumber(residentRequestDto.getSerialNum())
                .name(residentRequestDto.getName())
                .residentRegistrationNumber(residentRequestDto.getResidentRegistrationNum())
                .genderCode(residentRequestDto.getGender())
                .birthDate(residentRequestDto.getBirthDate())
                .birthPlaceCode(residentRequestDto.getBirthPlace())
                .registrationBaseAddress(residentRequestDto.getRegistrationBaseAddress())
                .build();

        Long residentSerialNumber = residentRepository.save(resident).getResidentSerialNumber();

        return residentRepository.findByResidentSerialNumber(residentSerialNumber);
    }

    @Override
    public ResidentResponseDto updateResident(Long residentSerialNumber, ResidentRequestDto residentRequestDto) {
        Resident resident = residentRepository.findById(residentSerialNumber)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 없습니다."));

        if (isName(residentRequestDto)) {
            resident.setName(residentRequestDto.getName());
        }

        if (isDeath(residentRequestDto)) {
            resident.setDeathDate(residentRequestDto.getDeathDate());
            resident.setDeathPlaceCode(residentRequestDto.getDeathPlace());
            resident.setDeathPlaceAddress(residentRequestDto.getDeathPlaceAddress());
        }

        Long updateResidentSerialNumber = residentRepository.save(resident).getResidentSerialNumber();

        return residentRepository.findByResidentSerialNumber(updateResidentSerialNumber);
    }

    private boolean isName(ResidentRequestDto residentRequestDto) {
        return residentRequestDto.getName() != null;
    }

    private boolean isDeath(ResidentRequestDto residentRequestDto) {
        return residentRequestDto.getDeathDate() != null;
    }
}
