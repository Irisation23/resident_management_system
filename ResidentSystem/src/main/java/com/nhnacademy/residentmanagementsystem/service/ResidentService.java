package com.nhnacademy.residentmanagementsystem.service;


import com.nhnacademy.residentmanagementsystem.dto.ResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Resident;

public interface ResidentService {

    int countToResidentByName(String name);
    int countToUpdateResidentByName(String name, Long residentSerialNumber);

    ResidentResponseDto registerResident(ResidentRequestDto residentRequestDto);

    ResidentResponseDto updateResident(Long residentSerialNumber, ResidentRequestDto residentRequestDto);
}
