package by.epam.classes.TaskB.deviceControl;

import by.epam.classes.TaskB.device.Device;
import by.epam.classes.TaskB.device.PluggableDevice;
import by.epam.classes.TaskB.device.SwitchableDevice;

import java.util.ArrayList;
import java.util.List;

public class DeviceControlCenter {

    private final List<Device> devices;

    public DeviceControlCenter() {
        devices = new ArrayList<>();
    }

    public void addDevice(String deviceName, int ... powerList){
        if (deviceName==null || deviceName.equals("")) {
            System.out.println("Device name can't be empty or null");
            return;
        } else {
            if (powerList[0] <= 0) {
                System.out.println("Device power should be a positive value");
                return;
            }
        }

        if (powerList.length == 2) {
            devices.add(new SwitchableDevice(deviceName, powerList[0], powerList[1]));
            System.out.println("Switchable device=" + deviceName + " was added");
        } else {
            devices.add(new PluggableDevice(deviceName, powerList[0]));
            System.out.println("Pluggable device=" + deviceName + " was added");
        }
    }

    public void deleteDevice (int id){
        if (id <= 0) {
            System.out.println("Device id should be a positive number");
            return;
        }
        devices.remove(getDevice(id));
        System.out.println("Device deleted");

    }

    public void powerOn (int id){
        if (devices.size() == 0) {
            System.out.println("Device list is empty. Please fill it before next attempt!");
        }else if (isIdCorrect(id)){
                System.out.println("Please input correct positive device id");
        }
            Device device = getDevice(id);
            if (device != null) {
                device.plugIn();
            }else {
                System.out.println("Device not found");
            }
    }

    public void powerOnAllDevices() {
        for (Device dev: devices) {
            dev.plugIn();
        }
    }

    public void powerOffAllDevices() {
        for (Device dev: devices) {
            dev.powerOff();
        }
    }

    public void powerOff (int id){
        if (devices.size() == 0) {
            System.out.println("Device list is empty. Please fill it before next attempt!");
        }else if (isIdCorrect(id)){
            System.out.println("Please input correct positive device id");
        }else {
            Device device = getDevice(id);
            if (device != null) {
            device.powerOff();
            }else {
                System.out.println("Device not found");
            }
        }
    }

    public void printTotalPowerConsumption(){
        int totalPowerConsumption = 0;
        ArrayList<Device> pluggedInDevices = pluggedInDevicesList();
            for (Device dev : pluggedInDevices){
                    totalPowerConsumption +=dev.getPower();
            }
            printDevicesSortedByPower();
            System.out.println();
            System.out.println("Power Consumption: " + totalPowerConsumption + " WATT");
    }


    public void printAllDevices(){
        if (devices.size() == 0) {
            System.out.println("Device list is empty");
            System.out.println("Repeat your input");
            return;
        }
        for (Device dev : devices) {
            System.out.println(dev);
        }
    }

    public void printDevicesSortedByPower(){
        ArrayList<Device> pluggedInDevices = pluggedInDevicesList();
        if (devices.size() != 0 && pluggedInDevices.size() != 0){
            System.out.println("List of pluggedIn devices sorted by power");
            pluggedInDevices.sort((device1, device2) -> device1.getPower() - device2.getPower());
            for (Device dev : pluggedInDevices){
                    System.out.println(dev);
                }
        }else {
            System.out.println("There are no pluggedIn devices. No power consumption!");
        }
    }

    public void findDevice (String deviceName, int power) {
         if (devices.size() == 0) {
            System.out.println("There are no devices");
            return;
        }else{
             boolean isFinded = false;
             for (Device dev : devices) {
                if (dev.getPassportPower() == power && deviceName.equalsIgnoreCase(dev.getDeviceName())) {
                    System.out.println("We have found device according to your query:");
                    System.out.println(dev);
                    isFinded = true;
                }
             }
             if (!isFinded){ System.out.println("There is no such devices");}
        }
    }

    private Device getDevice(int id){
        for (Device device: devices) {
            if(device.getId()==id) {
                return device;
            }
        }return null;
    }

    private boolean isIdCorrect (int id) {
        return getDevice(id) == null || id < 1;
    }

    private ArrayList<Device> pluggedInDevicesList() {
        ArrayList<Device> pluggedInDevicesList = new ArrayList<>();
        for (Device dev: devices) {
            if (dev.isPluggedIn()) {
                pluggedInDevicesList.add(dev);
            }
        }
        return pluggedInDevicesList;
    }
}


