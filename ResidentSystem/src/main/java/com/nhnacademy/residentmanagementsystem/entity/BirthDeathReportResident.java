package com.nhnacademy.residentmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {

    @EmbeddedId
    BirthDeathReportResidentPk birthDeathReportResidentPk;

    @Column(name = "birth_death_report_date")
    private LocalDate birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class BirthDeathReportResidentPk implements Serializable {

        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;

        @Column(name = "report_resident_serial_number")
        private Long reportResidentSerialNumber;

        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;
    }
}
