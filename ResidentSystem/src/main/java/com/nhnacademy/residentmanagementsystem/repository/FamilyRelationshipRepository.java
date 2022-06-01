package com.nhnacademy.residentmanagementsystem.repository;

import com.nhnacademy.residentmanagementsystem.dto.response.FamilyRelationshipResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship
        , FamilyRelationship.FamilyRelationshipPk> {
    FamilyRelationshipResponseDto findByFamilyRelationshipPk(FamilyRelationship.FamilyRelationshipPk familyRelationshipPk);
}
