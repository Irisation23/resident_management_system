package com.nhnacademy.residentmanagementsystem.service;

import com.nhnacademy.residentmanagementsystem.dto.request.MemberRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;

public interface MemberService {
    ResidentResponseDto registerMember(Long serialNum, MemberRequestDto memberRequestDto);
}
