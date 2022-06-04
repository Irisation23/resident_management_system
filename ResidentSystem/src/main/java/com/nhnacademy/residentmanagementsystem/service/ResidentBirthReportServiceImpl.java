package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentBirthReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindBirthDeathReportResident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentBirthReportServiceImpl implements ResidentBirthReportService{

    private final ResidentRepository residentRepository;
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    public ResidentBirthReportServiceImpl(ResidentRepository residentRepository, BirthDeathReportResidentRepository birthDeathReportResidentRepository) {
        this.residentRepository = residentRepository;
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
    }

    @Override
    @Transactional
    public ResidentBirthDeathReportResponseDto registerBirthResident(Long serialNumber, ResidentBirthReportRequestDto residentBirthReportRequestDto) {

        Resident birthReportResident = residentRepository.findById(serialNumber) //신고자
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        Resident birthResident = residentRepository.findById(residentBirthReportRequestDto.getSerialNum()) //애
                .orElse(Resident.builder()
                        .residentSerialNumber(residentBirthReportRequestDto.getSerialNum())
                        .name(residentBirthReportRequestDto.getName())
                        .residentRegistrationNumber(residentBirthReportRequestDto.getResidentRegistrationNum())
                        .genderCode(residentBirthReportRequestDto.getGender())
                        .birthDate(residentBirthReportRequestDto.getBirthDate())
                        .birthPlaceCode(residentBirthReportRequestDto.getBirthPlace())
                        .registrationBaseAddress(residentBirthReportRequestDto.getRegistrationBaseAddress())
                .build());

        residentRepository.save(birthResident);


        BirthDeathReportResident.BirthDeathReportResidentPk birthDeathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("출생"
                        , birthReportResident.getResidentSerialNumber()
                        , birthResident.getResidentSerialNumber());

        BirthDeathReportResident birthDeathReportResident =
                new BirthDeathReportResident(birthDeathReportResidentPk
                        , residentBirthReportRequestDto.getReportDate()
                        , residentBirthReportRequestDto.getBirthReportQualifications()
                ,null
                , residentBirthReportRequestDto.getEmailAddress()
                        , residentBirthReportRequestDto.getPhoneNumber()
                        , birthResident);

        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return birthDeathReportResidentRepository.findByBirthDeathReportResidentPk(birthDeathReportResidentPk);
    }

    @Override
    @Transactional
    public ResidentBirthDeathReportResponseDto updateBirthResident(Long serialNumber, Long targetSerialNumber, ResidentBirthReportRequestDto residentBirthReportRequestDto) {

        Resident birthResident = residentRepository.findById(targetSerialNumber)
                .orElseThrow(()->new NotFindResidentException("해당 신생아는 없습니다."));
        
        Resident birthReportResident = residentRepository.findById(serialNumber)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        BirthDeathReportResident.BirthDeathReportResidentPk birthDeathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("출생"
                        , birthReportResident.getResidentSerialNumber()
                        , birthResident.getResidentSerialNumber());

        BirthDeathReportResident foundBirthDeathReportResident = birthDeathReportResidentRepository.findById(birthDeathReportResidentPk)
                .orElseThrow(() -> new NotFindBirthDeathReportResident("해당 신고를 한 주민은 존재하지 않습니다."));

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident(birthDeathReportResidentPk
                , foundBirthDeathReportResident.getBirthDeathReportDate()
                , foundBirthDeathReportResident.getBirthReportQualificationsCode()
                , foundBirthDeathReportResident.getDeathReportQualificationsCode()
                , foundBirthDeathReportResident.getEmailAddress()
                , foundBirthDeathReportResident.getPhoneNumber()
                , birthResident);

        if(foundBirthDeathReportResident.getBirthReportQualificationsCode() != null) {

            birthDeathReportResident.setBirthReportQualificationsCode(residentBirthReportRequestDto.getBirthReportQualifications());
        }
        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return birthDeathReportResidentRepository.findByBirthDeathReportResidentPk(birthDeathReportResidentPk);
    }

    @Override
    @Transactional
    public String deleteBirthResident(Long serialNumber, Long targetSerialNumber) {
        Resident birthResident = residentRepository.findById(targetSerialNumber)
                .orElseThrow(()->new NotFindResidentException("해당 신생아는 없습니다."));

        Resident birthReportResident = residentRepository.findById(serialNumber)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        BirthDeathReportResident.BirthDeathReportResidentPk birthDeathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("출생"
                        , birthReportResident.getResidentSerialNumber()
                        , birthResident.getResidentSerialNumber());

        BirthDeathReportResident foundBirthDeathReportResident = birthDeathReportResidentRepository.findById(birthDeathReportResidentPk)
                .orElseThrow(() -> new NotFindBirthDeathReportResident("해당 신고를 한 주민은 존재하지 않습니다."));

        birthDeathReportResidentRepository.delete(foundBirthDeathReportResident);
        return "삭제완료!";
    }

}
