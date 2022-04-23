package ma.enset.patientmvc.security.repositories;

import ma.enset.patientmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserReository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
