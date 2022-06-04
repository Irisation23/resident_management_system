package com.nhnacademy.residentmanagementsystem.controller.restcontroller;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentDeathReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;
import com.nhnacademy.residentmanagementsystem.service.ResidentDeathReportService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResidentDeathReportController {
    private final ResidentDeathReportService residentDeathReportService;

    public ResidentDeathReportController(ResidentDeathReportService residentDeathReportService) {
        this.residentDeathReportService = residentDeathReportService;
    }

    @PostMapping(value = "/residents/{serialNum}/death")
    ResidentBirthDeathReportResponseDto registerResidentDeathReport(@PathVariable("serialNum") Long serialNum
            , @RequestBody ResidentDeathReportRequestDto residentDeathReportRequestDto) {
        return residentDeathReportService.registerDeathReport(serialNum,residentDeathReportRequestDto);
    }

    @PutMapping(value = "/residents/{serialNum}/death/{targetSerialNum}")
    ResidentBirthDeathReportResponseDto updateResidentDeathReport(@PathVariable("serialNum") Long serialNum
                                                                , @PathVariable("targetSerialNum") Long targetSerialNum
                                                                , @RequestBody ResidentDeathReportRequestDto residentDeathReportRequestDto) {
        return residentDeathReportService.updateDeathReport(serialNum,targetSerialNum,residentDeathReportRequestDto);
    }

    @DeleteMapping(value = "/residents/{serialNum}/death/{targetSerialNum}" ,produces = "application/json; charset=utf8")
    String deleteResidentDeathReport(@PathVariable("serialNum") Long serialNumber
                                    , @PathVariable("targetSerialNum") Long targetSerialNum){
        return residentDeathReportService.deleteDeathReport(serialNumber,targetSerialNum);
    }

}
