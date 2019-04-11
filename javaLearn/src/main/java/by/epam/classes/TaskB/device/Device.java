package by.epam.classes.TaskB.device;

import java.util.Objects;

public abstract class Device {

    private static int deviceIdCounter = 0;

    private int id;
    private String deviceName;
    private int power;

    Device() {
    }


    Device(String deviceName, int power) {
        id = ++deviceIdCounter;
        this.deviceName = deviceName;
        this.power = power;
    }

    public String getDeviceName() { return deviceName; } // Получение названия электроприбора
    public int getId() {return id;}     // Получение id электроприбора
    public int getPassportPower() {return power;}     // Вывод значения паспортной мощности

    public abstract int getPower();// Вывод реальной потребляемой мощности
    public abstract void plugIn();     //Вставить вилку в розетку
    public abstract void plugOut();    //Достать вилку из розетки
    public abstract void powerOff();   //Выключить электроприбор
    public abstract boolean isPluggedIn(); // Проверяет включен ли прибор в розетку

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return id == device.id &&
                power == device.power &&
                deviceName.equals(device.deviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceName, power);
    }

}
