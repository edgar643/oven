package com.pepetech.oven.repositories;

import com.pepetech.oven.entities.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametersRepository extends JpaRepository<Parameters, Long> {
}
