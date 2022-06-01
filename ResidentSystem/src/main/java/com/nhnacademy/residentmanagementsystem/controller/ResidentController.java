package com.nhnacademy.residentmanagementsystem.controller;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.service.ResidentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResidentController {
    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @PostMapping(value = "/residents")
    ResidentResponseDto registerResident(@RequestBody ResidentRequestDto residentRequestDto) {
        return residentService.registerResident(residentRequestDto);
    }

    @PutMapping(value = "/residents/{resident_serial_number}")
    ResidentResponseDto updateResident(@PathVariable("resident_serial_number") Long residentSerialNumber
            , @RequestBody ResidentRequestDto residentRequestDto) {
        return residentService.updateResident(residentSerialNumber, residentRequestDto);

    }
}
