package com.nhnacademy.residentmanagementsystem.controller.restcontroller;

import com.nhnacademy.residentmanagementsystem.dto.request.MemberRequestDto;
import com.nhnacademy.residentmanagementsystem.dto.response.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/member/{serialNum}/register")
    public ResidentResponseDto registerMember(@PathVariable Long serialNum
    , @RequestBody MemberRequestDto memberRequestDto){
        return memberService.registerMember(serialNum,memberRequestDto);
    }
}
