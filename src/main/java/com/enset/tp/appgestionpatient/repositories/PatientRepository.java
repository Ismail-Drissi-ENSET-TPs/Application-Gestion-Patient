package com.enset.tp.appgestionpatient.repositories;

import com.enset.tp.appgestionpatient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
