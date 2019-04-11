package by.epam.classes.TaskA;

import by.epam.classes.TaskA.patient.Patient;
import by.epam.classes.TaskA.patientAction.PatientAction;

import java.util.Arrays;
import java.util.List;

public class PatientRunner {
    static List<Patient> patients = Arrays.asList(
            new Patient(1, "Ivanov", "Petr", "Ivanovich", "Gomel", "+375291234567", 154, "flu"),
            new Patient(2, "Petrov", "Ivan", "Sergeevich", "Minsk", "+375291234567", 156, "orvi"),
            new Patient(3, "Sidorov", "Mihail", "Petrovich", "Vitebsk", "+375291234567", 158, "nose"),
            new Patient(4, "Golovin", "Andrey", "Mihailovich", "Brest", "+375291234567", 15, "flu"),
            new Patient(5, "Zilin", "Fedor", "Stepanovich", "Mogilev", "+375291234567", 150, "ears"),
            new Patient(6, "Semechkin", "Alex", "Vadimovich", "Parichi", "+375291234567", 184, "head"),
            new Patient(8, "Palchik", "Olga", "Petrovna", "Azarichi", "+375291234567", 1574, "heart")
    );

    public static void main(String[] args) {
        PatientAction patientAction = new PatientAction(patients);
        System.out.println();
        System.out.println("Patients list:");
        System.out.println(patientAction.getPatientList().toString());
        System.out.println();
        System.out.println("Patient list with diagnose = FLU");
        System.out.println(patientAction.getPatientsListWithDiagnose("FLu").toString());
        System.out.println();
        System.out.println("Patient list with ID MedCard in the interval:  from 154 to 184");
        System.out.println(patientAction.getPatientsListByIdMedCardInterval(154,184).toString());
    }



}
