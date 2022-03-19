package ma.enset.jpa_assoc.service;

import ma.enset.jpa_assoc.entities.Consultation;
import ma.enset.jpa_assoc.entities.Medecin;
import ma.enset.jpa_assoc.entities.Patient;
import ma.enset.jpa_assoc.entities.RendezVous;


public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}