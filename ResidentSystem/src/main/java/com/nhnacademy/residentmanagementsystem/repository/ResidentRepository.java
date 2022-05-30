package com.nhnacademy.residentmanagementsystem.repository;

import com.nhnacademy.residentmanagementsystem.dto.ResidentResponseDto;
import com.nhnacademy.residentmanagementsystem.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ResidentRepository extends JpaRepository<Resident
        , Long> {
    //select (*) from resident
    @Query(value = "SELECT COUNT (*) FROM resident WHERE name LIKE ?1"
            , nativeQuery = true)
    int countByNameLike(String name);

    @Modifying
    @Query("UPDATE Resident r SET r.name = :name WHERE r.residentSerialNumber = :residentSerialNumber")
    int updateResidentName(@Param("name") String name
            , @Param("residentSerialNumber") Long residentSerialNumber);

    ResidentResponseDto findByResidentSerialNumber(Long residentSerialNumber);
    //원래는 findById (findByResdentSerialNumber) 결과가 Optional<Resident>
    // 이 결과를 다시 Dto로 변환해서 반환해줌
}
