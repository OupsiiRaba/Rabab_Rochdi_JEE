package ma.enset.jpa_assoc;


import ma.enset.jpa_assoc.entities.*;
import ma.enset.jpa_assoc.repositories.ConsultationRepository;
import ma.enset.jpa_assoc.repositories.MedecinRepository;
import ma.enset.jpa_assoc.repositories.PatientRepository;
import ma.enset.jpa_assoc.repositories.RendezVousRepository;
import ma.enset.jpa_assoc.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaAssocApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssocApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,
                            MedecinRepository medecinRepository) {
        return args -> {
            // Execution instanciation des objets dans la base de données
            Stream.of("Rabab", "wissale", "yass")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("saly", "mery", "oumi")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name + "@hospital.ma");
                        medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "chirurgie");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Rabab");

            Medecin medecin = medecinRepository.findByNom("Saly");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateCreation(new Date());
            rendezVous.setStatus(StatusRDV.CANCELED);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous savedRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println(savedRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapportConsultation("rapport...");
            hospitalService.saveConsultation(consultation);
        };
    }

}