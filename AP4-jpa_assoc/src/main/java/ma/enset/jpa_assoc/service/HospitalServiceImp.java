package ma.enset.jpa_assoc.service;

import ma.enset.jpa_assoc.entities.Consultation;
import ma.enset.jpa_assoc.entities.Medecin;
import ma.enset.jpa_assoc.entities.Patient;
import ma.enset.jpa_assoc.entities.RendezVous;
import ma.enset.jpa_assoc.repositories.ConsultationRepository;
import ma.enset.jpa_assoc.repositories.MedecinRepository;
import ma.enset.jpa_assoc.repositories.PatientRepository;
import ma.enset.jpa_assoc.repositories.RendezVousRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImp implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImp(PatientRepository patientRepository,
                              MedecinRepository medecinRepository,
                              RendezVousRepository rendezVousRepository,
                              ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        //Generate Random UUID
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}