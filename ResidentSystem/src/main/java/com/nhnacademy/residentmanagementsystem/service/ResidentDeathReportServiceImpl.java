package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.ResidentDeathReportRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentBirthDeathReportResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.BirthDeathReportResident;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidentDeathReportServiceImpl implements ResidentDeathReportService {

    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private final ResidentRepository residentRepository;

    public ResidentDeathReportServiceImpl(BirthDeathReportResidentRepository birthDeathReportResidentRepository, ResidentRepository residentRepository) {

        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    @Transactional
    public ResidentBirthDeathReportResponseDto registerDeathReport(Long serialNum, ResidentDeathReportRequestDto residentDeathReportRequestDto) {

        Resident deathResident = residentRepository.findById(residentDeathReportRequestDto.getSerialNum())
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        deathResident.setDeathDate(residentDeathReportRequestDto.getDeathDate());
        deathResident.setDeathPlaceCode(residentDeathReportRequestDto.getDeathPlaceCode());
        deathResident.setDeathPlaceAddress(residentDeathReportRequestDto.getDeathPlaceAddress());

        residentRepository.save(deathResident);

        BirthDeathReportResident.BirthDeathReportResidentPk deathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("사망", serialNum, residentDeathReportRequestDto.getSerialNum());

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident(deathReportResidentPk
                , residentDeathReportRequestDto.getReportDate()
                , null
                , residentDeathReportRequestDto.getDeathReportQualifications()
                , residentDeathReportRequestDto.getEmailAddress()
                , residentDeathReportRequestDto.getPhoneNumber()
                , deathResident);

        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return birthDeathReportResidentRepository.findByBirthDeathReportResidentPk(deathReportResidentPk);
    }

    @Override
    @Transactional
    public ResidentBirthDeathReportResponseDto updateDeathReport(Long serialNum, Long targetSerialNum, ResidentDeathReportRequestDto residentDeathReportRequestDto) {

        Resident reportDeathResident = residentRepository.findById(serialNum)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        Resident deathResident = residentRepository.findById(targetSerialNum)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 존재하지 않습니다."));

        if (isDeath(deathResident)) {
            deathResident.setDeathPlaceCode(residentDeathReportRequestDto.getDeathPlaceCode());
        }

        residentRepository.save(deathResident);

        BirthDeathReportResident.BirthDeathReportResidentPk deathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("사망", serialNum, targetSerialNum);

        ResidentBirthDeathReportResponseDto residentBirthDeathReport = birthDeathReportResidentRepository.findByBirthDeathReportResidentPk(deathReportResidentPk);

        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident(deathReportResidentPk
                , residentBirthDeathReport.getBirthDeathReportDate()
                , null
                , residentDeathReportRequestDto.getDeathReportQualifications()
                , residentBirthDeathReport.getEmailAddress()
                , residentBirthDeathReport.getPhoneNumber()
                , deathResident);

        birthDeathReportResidentRepository.save(birthDeathReportResident);

        return birthDeathReportResidentRepository.findByBirthDeathReportResidentPk(deathReportResidentPk);
    }

    @Override
    public String deleteDeathReport(Long serialNum, Long targetSerialNum) {

        BirthDeathReportResident.BirthDeathReportResidentPk deathReportResidentPk =
                new BirthDeathReportResident.BirthDeathReportResidentPk("사망", serialNum, targetSerialNum);

        birthDeathReportResidentRepository.deleteById(deathReportResidentPk);

        return "동묘 교수님, 마르코 교수님 사망정보 삭제 완료 했습니다. 충성 충성 ^_^77 ㅎㅎ";
    }

    private boolean isDeath(Resident deathResident) {
        return deathResident.getDeathPlaceCode() != null;
    }
}
