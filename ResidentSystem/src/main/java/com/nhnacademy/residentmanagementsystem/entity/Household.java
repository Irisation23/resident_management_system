package com.nhnacademy.residentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Long householdSerialNumber;

    @Column(name = "household_composition_date")
    private LocalDate householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;

    @ManyToOne
    @JoinColumn(name = "household_resident_serial_number")
    private Resident resident;

    @OneToMany(mappedBy = "household")
    @JsonIgnore
    private List<HouseholdMovementAddress> householdMovementAddressList;

    @OneToMany(mappedBy = "household")
    @JsonIgnore
    private List<HouseholdCompositionResident> householdCompositionResidentList;



}
