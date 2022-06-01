package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentDeathReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;

public interface ResidentDeathReportService {
    ResidentBirthDeathReportResponseDto registerDeathReport(Long serialNum, ResidentDeathReportRequestDto residentDeathReportRequestDto);

    ResidentBirthDeathReportResponseDto updateDeathReport(Long serialNum, Long targetSerialNum, ResidentDeathReportRequestDto residentDeathReportRequestDto);

    String deleteDeathReport(Long serialNum, Long targetSerialNum);
}
