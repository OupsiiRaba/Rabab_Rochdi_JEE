package ma.enset.jpa_assoc.repositories;

import ma.enset.jpa_assoc.entities.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);
}