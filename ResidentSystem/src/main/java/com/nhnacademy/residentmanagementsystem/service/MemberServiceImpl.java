package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.MemberRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import com.nhnacademy.residentmanagementsystem.exception.NotFindResidentException;
import com.nhnacademy.residentmanagementsystem.repository.ResidentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    private final ResidentRepository residentRepository;
    private final PasswordEncoder passwordEncoder;


    public MemberServiceImpl(ResidentRepository residentRepository, PasswordEncoder passwordEncoder) {
        this.residentRepository = residentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public ResidentResponseDto registerMember(Long serialNum, MemberRequestDto memberRequestDto) {

        Resident memberAddResident = residentRepository.findById(serialNum)
                .orElseThrow(() -> new NotFindResidentException("해당 주민은 없습니다."));

        memberAddResident.setUserName(memberRequestDto.getId());
        memberAddResident.setPassword(passwordEncoder.encode(memberRequestDto.getPassword()));
        memberAddResident.setEmail(memberRequestDto.getEmail());

        String addUserName = residentRepository.saveAndFlush(memberAddResident).getUserName();

        return residentRepository.findByUserName(addUserName);
    }
}
