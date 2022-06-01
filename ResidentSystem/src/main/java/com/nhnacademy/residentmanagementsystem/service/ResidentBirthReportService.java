package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentBirthReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;

public interface ResidentBirthReportService {
    ResidentBirthDeathReportResponseDto registerBirthResident(Long serialNumber, ResidentBirthReportRequestDto residentBirthRequestDto);

    ResidentBirthDeathReportResponseDto updateBirthResident(Long serialNumber, Long targetSerialNumber, ResidentBirthReportRequestDto residentBirthReportRequestDto);

    String deleteBirthResident(Long serialNumber, Long targetSerialNumber);
}
