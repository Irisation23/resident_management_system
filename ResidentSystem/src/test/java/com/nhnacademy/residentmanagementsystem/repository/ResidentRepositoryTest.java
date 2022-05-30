package com.nhnacademy.residentmanagementsystem.repository;

import com.nhnacademy.residentmanagementsystem.config.RootConfig;
import com.nhnacademy.residentmanagementsystem.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ResidentRepositoryTest {
    @Autowired
    private ResidentRepository residentRepository;
    @Test
    void countByNameLike() {
        int findResidentNum = residentRepository.countByNameLike("남%");
        assertThat(findResidentNum).isEqualTo(4);
    }

    @Test
    void fuck() {
        residentRepository.findAll();
    }

    @Test
    @Rollback
    void updateCountByName() {
        int findUpdateResidentNum = residentRepository.updateResidentName("남길동임",1L);
        assertThat(findUpdateResidentNum).isEqualTo(1);
    }
}