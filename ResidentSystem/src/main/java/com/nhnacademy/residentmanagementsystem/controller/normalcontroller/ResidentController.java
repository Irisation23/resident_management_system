//package com.nhnacademy.residentmanagementsystem.controller.normalcontroller;
//
//import com.nhnacademy.residentmanagementsystem.entity.Resident;
//import com.nhnacademy.residentmanagementsystem.service.ResidentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//public class ResidentController {
//
//    private final ResidentService residentService;
//
//    public ResidentController(ResidentService residentService) {
//        this.residentService = residentService;
//    }
//
//    @GetMapping("resident")
//    public ModelAndView residents() {
//        ModelAndView mav = new ModelAndView("redirect:/resdient");
//        List<Resident> residentList = residentService.findResidentList();
//        mav.addObject("residentList",residentList);
//
//        return mav;
//    }
//}
