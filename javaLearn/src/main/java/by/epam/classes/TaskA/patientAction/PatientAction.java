package by.epam.classes.TaskA.patientAction;


import by.epam.classes.TaskA.patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientAction {

    private List<Patient> patients;

    public PatientAction(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatientList() {
        return this.patients;
    }

    public List<Patient> getPatientsListWithDiagnose(String diagnose) {
        List<Patient> patientsListWithDiagnose = new ArrayList<>();
        for (Patient patient : this.patients) {
            if (patient.getDiagnose().equalsIgnoreCase(diagnose)) {
                patientsListWithDiagnose.add(patient);
            }
        }
        return patientsListWithDiagnose;
    }

    public List<Patient> getPatientsListByIdMedCardInterval(int startId, int endId) {
        List<Patient> patientsListByIdMedCardInterval = new ArrayList<>();
        for (Patient patient : this.patients) {
            if (patient.getMedCardId() >= startId && patient.getMedCardId() <= endId) {
                patientsListByIdMedCardInterval.add(patient);
            }
        }
        return patientsListByIdMedCardInterval;
    }
}
