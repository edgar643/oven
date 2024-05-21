
package com.pepetech.oven.repositories;

import com.pepetech.oven.entities.DataOven;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DataOvenRepository extends JpaRepository<DataOven, Long> {
    @Query("SELECT d FROM DataOven d WHERE d.date BETWEEN :startDate AND :endDate")
    List<DataOven> findAllByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}