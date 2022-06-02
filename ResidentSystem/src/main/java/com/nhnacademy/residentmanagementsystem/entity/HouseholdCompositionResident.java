package com.nhnacademy.residentmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {

    @EmbeddedId
    private HouseholdCompositionResidentPk householdCompositionResidentPk;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "household_relationship_code")
    private String householdRelationShipCode;

    @Column(name="household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class HouseholdCompositionResidentPk implements Serializable {

        @Column(name = "household_serial_number")
        private Long householdSerialNumber;

        @Column(name = "resident_serial_nuber")
        private Long residentSerialNumber;
    }
}
