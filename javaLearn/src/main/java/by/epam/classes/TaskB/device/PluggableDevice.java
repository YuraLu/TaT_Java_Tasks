package by.epam.classes.TaskB.device;

import java.util.Objects;

public class PluggableDevice extends Device{
    private boolean isPlugged;

    public PluggableDevice(String deviceName, int power) {
        super(deviceName, power);
    }

    //Вставить вилку в розетку
    public void plugIn() {
        isPlugged = true;
    }

    //Достать вилку из розетки
    public void plugOut() {
        isPlugged = false;
    }

    //    Проверка - включен ли в розетку
    public boolean isPluggedIn() {
        return isPlugged;
    }

    //    Выключение электроприбора
    public void powerOff() {
        plugOut();
    }

    // Вывод реальной потребляемой мощности
    public int getPower() {
        if (isPluggedIn()){
            return getPassportPower();
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", isPlugged=" + isPlugged +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PluggableDevice)) return false;
        if (!super.equals(o)) return false;
        PluggableDevice pluggableDevice = (PluggableDevice) o;
        return isPlugged == pluggableDevice.isPlugged;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

}
