package com.nhnacademy.residentmanagementsystem.service;


import com.nhnacademy.residentmanagementsystem.dto.request.ResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Resident;

import java.util.List;

public interface ResidentService {

    int countToResidentByName(String name);
    int countToUpdateResidentByName(String name, Long residentSerialNumber);

    ResidentResponseDto registerResident(ResidentRequestDto residentRequestDto);

    ResidentResponseDto updateResident(Long residentSerialNumber, ResidentRequestDto residentRequestDto);

    List<Resident> findResidentList();
}
