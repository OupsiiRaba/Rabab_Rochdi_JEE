package ma.enset.jpa_assoc.repositories;

import ma.enset.jpa_assoc.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}