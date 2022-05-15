package ma.enset.jpa_assoc.repositories;

import ma.enset.jpa_assoc.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
