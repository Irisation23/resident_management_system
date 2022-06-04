package com.nhnacademy.residentmanagementsystem.controller.restcontroller;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentBirthReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;
import com.nhnacademy.residentmanagementsystem.service.ResidentBirthReportService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResidentBirthReportController {
    private final ResidentBirthReportService residentBirthReportService;

    public ResidentBirthReportController(ResidentBirthReportService residentBirthReportService) {
        this.residentBirthReportService = residentBirthReportService;
    }

    @PostMapping(value = "/residents/{serialNumber}/birth")
    ResidentBirthDeathReportResponseDto registerBirthResident(@PathVariable("serialNumber") Long serialNumber,
                                                              @RequestBody ResidentBirthReportRequestDto residentBirthRequestDto) {
        return residentBirthReportService.registerBirthResident(serialNumber, residentBirthRequestDto);
    }

    @PutMapping(value = "/residents/{serialNumber}/birth/{targetSerialNumber}")
    ResidentBirthDeathReportResponseDto updateBirthResident(@PathVariable("serialNumber") Long serialNumber,
                                                            @PathVariable("targetSerialNumber") Long targetSerialNumber,
                                                            @RequestBody ResidentBirthReportRequestDto residentBirthReportRequestDto){
        return residentBirthReportService.updateBirthResident(serialNumber,targetSerialNumber,residentBirthReportRequestDto);
    }

    @DeleteMapping(value = "/residents/{serialNumber}/birth/{targetSerialNumber}" ,produces = "application/json; charset=utf8")
    String deleteBirthResident(@PathVariable("serialNumber") Long serialNumber,
                               @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        return residentBirthReportService.deleteBirthResident(serialNumber,targetSerialNumber);
    }

}
