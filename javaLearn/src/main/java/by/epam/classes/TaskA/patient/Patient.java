package by.epam.classes.TaskA.patient;

import java.util.Objects;

public class Patient {
//    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//    Определить дополнительно методы в классе, создающем массив объектов.
//    Задать критерий выбора данных и вывести эти данные на консоль.
//    В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

//3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты, Диагноз.
//    Создать массив объектов. Вывести:
//    a) список пациентов, имеющих данный диагноз;
//    b) список пациентов, номер медицинской карты которых находится в заданном интервале.
    private  int id;
    private String surname;
    private String name;
    private String middleName;
    private String address;
    private String phone;
    private int medCardId;
    private String diagnose;

    public Patient() {
    }

    public Patient(int id, String surname, String name, String middleName, String address, String phone, int medCardId, String diagnose) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.medCardId = medCardId;
        this.diagnose = diagnose;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMedCardId() {
        return medCardId;
    }

    public void setMedCardId(int medCardId) {
        this.medCardId = medCardId;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", medCardId=" + medCardId +
                ", diagnose='" + diagnose + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                medCardId == patient.medCardId &&
                Objects.equals(phone, patient.phone) &&
                Objects.equals(surname, patient.surname) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(middleName, patient.middleName) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(diagnose, patient.diagnose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, middleName, address, phone, medCardId, diagnose);
    }
}
