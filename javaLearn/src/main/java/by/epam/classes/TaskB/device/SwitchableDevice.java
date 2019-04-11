package by.epam.classes.TaskB.device;

import java.util.Objects;

public class SwitchableDevice extends PluggableDevice {
    private int standByPower;
    private boolean isSwitched;

    public SwitchableDevice(String deviceName, int power, int standByPower) {
        super(deviceName, power);
        this.standByPower = standByPower;
    }

    //    Включение и выход из режима StanBy
    private void switchOn() {
        isSwitched = true;
    }

    //    Перевод электроприбора в режим StanBy
    private void switchOff() {
        isSwitched = false;
    }

    //    Проверка - в режиме StanBy или нет
    private boolean isSwitchedOn() {
        return isSwitched;
    }

    // Вывод значения паспортной мощности
    private int getStandByPower() {
        return standByPower;
    }

    //Вставить вилку в розетку
    @Override
    public void plugIn() {
        super.plugIn();
        switchOn();
    }

    //Достать вилку из розетки
    @Override
    public void plugOut() {
        super.plugOut();
        switchOff();
    }

    //    Выключение электроприбора
    @Override
    public void powerOff() {
        switchOff();
    }

    // Вывод реальной потребляемой мощности
    @Override
    public int getPower() {
        if (isPluggedIn() && !isSwitchedOn()){
            return getStandByPower();
        }else {
            return super.getPower();
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", standByPower=" + standByPower +
                ", isSwitched=" + isSwitched +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SwitchableDevice)) return false;
        if (!super.equals(o)) return false;
        SwitchableDevice that = (SwitchableDevice) o;
        return standByPower == that.standByPower &&
                isSwitched == that.isSwitched;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), standByPower);
    }
}
