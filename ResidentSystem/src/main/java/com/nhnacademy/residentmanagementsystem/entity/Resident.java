package com.nhnacademy.residentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {

    @Id
    @Column(name = "resident_serial_number")
    private Long residentSerialNumber;

    private String name;

    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber;

    @Column(name = "gender_code")
    private String genderCode;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "birth_place_code")
    private String birthPlaceCode;

    @Column(name = "registration_base_address")
    private String registrationBaseAddress;

    @Column(name = "death_date")
    private LocalDateTime deathDate;

    @Column(name = "death_place_code")
    private String deathPlaceCode;

    @Column(name = "death_place_address")
    private String deathPlaceAddress;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    List<BirthDeathReportResident> birthDeathReportResidentList;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    List<FamilyRelationship> familyRelationshipList;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    List<CertificateIssue> certificateIssueList;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    List<HouseholdCompositionResident> householdCompositionResidentList;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    List<Household> householdList;

}
