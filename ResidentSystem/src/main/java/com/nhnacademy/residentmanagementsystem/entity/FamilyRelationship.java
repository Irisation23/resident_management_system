package com.nhnacademy.residentmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private FamilyRelationshipPk familyRelationshipPk;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident resident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class FamilyRelationshipPk implements Serializable {

        @Column(name = "family_resident_serial_number")
        private Long familyResidentSerialNumber;

        @Column(name = "base_resident_serial_number")
        private Long baseResidentSerialNumber;

    }
}
