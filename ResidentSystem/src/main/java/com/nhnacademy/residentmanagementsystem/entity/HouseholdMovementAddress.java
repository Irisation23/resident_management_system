package com.nhnacademy.residentmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {

    @EmbeddedId
    private HouseholdMovementAddressPk householdMovementAddressPk;

    @Column(name = "house_movement_address")
    private String houseMovementAddress;

    @Column(name = "last_address_yn")
    private String lastAddressYn;

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
    public class HouseholdMovementAddressPk implements Serializable {
        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate;

        @Column(name = "household_serial_number")
        private Long householdSerialNumber;
    }
}
